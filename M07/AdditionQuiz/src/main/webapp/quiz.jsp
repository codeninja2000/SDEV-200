<%--
    Quiz JSP Page
    This page generates a simple addition quiz with a configurable number of questions.
    Users can answer the questions and receive feedback on their performance.
    The quiz questions are generated pseudo-randomly.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Addition Quiz</title>
    <style>
        .quiz-form {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            max-width: 600px;
        }
        .question {
            margin: 10px 0;
            padding: 10px;
            background-color: #f9f9f9;
        }
        .result {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f0f0f0;
        }
        input[type="number"] {
            width: 100px;
            padding: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .home-link {
            margin: 20px;
            display: inline-block;
            padding: 10px 20px;
            background-color: #008CBA;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .correct { color: green; }
        .incorrect { color: red; }
    </style>
</head>
<body>
    <h1>Addition Quiz</h1>
    
    <%
        // Get question count from parameter or session
        int questionCount = 5; // default value
        String countParam = request.getParameter("questionCount");
        if (countParam != null && !countParam.trim().isEmpty()) {
            try {
                questionCount = Math.min(20, Math.max(1, Integer.parseInt(countParam)));
                session.setAttribute("questionCount", questionCount);
            } catch (NumberFormatException e) {
                // Display error page
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid question count: " + countParam);
            }
        } else if (session.getAttribute("questionCount") != null) {
            questionCount = (Integer)session.getAttribute("questionCount");
        }

        // Check if this is the first time loading the page
        if (session.getAttribute("numbers1") == null) {
            // Generate random number pairs for the quiz
            int[] numbers1 = new int[questionCount];
            int[] numbers2 = new int[questionCount];
            
            for (int i = 0; i < questionCount; i++) {
                numbers1[i] = (int)(Math.random() * 50) + 1;
                numbers2[i] = (int)(Math.random() * 50) + 1;
            }
            
            session.setAttribute("numbers1", numbers1);
            session.setAttribute("numbers2", numbers2);
        }
    %>


    <%
        if ("POST".equals(request.getMethod())) {
            int[] numbers1 = (int[])session.getAttribute("numbers1");
            int[] numbers2 = (int[])session.getAttribute("numbers2");
            int score = 0;
            
            // Check answers
            for (int i = 0; i < numbers1.length; i++) {
                String userAnswer = request.getParameter("answer" + i);
                int correctAnswer = numbers1[i] + numbers2[i];
                
                if (userAnswer != null && !userAnswer.trim().isEmpty()) {
                    try {
                        if (Integer.parseInt(userAnswer) == correctAnswer) {
                            score++;
                        }
                    } catch (NumberFormatException e) {
                        // Display error page
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for question " + (i + 1));

                    }
                }
            }
    %>
            <div class="result">
                <h2>Your score: <%= score %> out of <%= numbers1.length %></h2>
                <%
                    // Show correct answers
                    for (int i = 0; i < numbers1.length; i++) {
                        int correctAnswer = numbers1[i] + numbers2[i];
                        String userAnswer = request.getParameter("answer" + i);
                        boolean isCorrect = false;
                        try {
                            isCorrect = Integer.parseInt(userAnswer) == correctAnswer;
                        } catch (NumberFormatException e) {
                            // Display error page
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for question " + (i + 1));
                        }
                %>
                    <p class="<%= isCorrect ? "correct" : "incorrect" %>">
                        Question <%= i + 1 %>: <%= numbers1[i] %> + <%= numbers2[i] %> = <%= correctAnswer %>
                        (Your answer: <%= userAnswer %>)
                    </p>
                <% } %>
                <br>
                <a href="index.jsp" class="home-link">New Quiz</a>
            </div>
    <%
            // Clear the session for next quiz
            session.removeAttribute("numbers1");
            session.removeAttribute("numbers2");
            session.removeAttribute("questionCount");
        } else {
            // Display the quiz
            int[] numbers1 = (int[])session.getAttribute("numbers1");
            int[] numbers2 = (int[])session.getAttribute("numbers2");
    %>
            <form method="post" class="quiz-form">
                <h3>Number of questions: <%= numbers1.length %></h3>
                <% for (int i = 0; i < numbers1.length; i++) { %>
                    <div class="question">
                        Question <%= i + 1 %>: 
                        <%= numbers1[i] %> + <%= numbers2[i] %> = 
                        <input type="number" name="answer<%= i %>" required>
                    </div>
                <% } %>
                <br>
                <input type="submit" value="Submit Answers">
            </form>
    <% } %>
</body>
</html>