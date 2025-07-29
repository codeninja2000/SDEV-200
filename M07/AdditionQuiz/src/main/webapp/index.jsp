<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Addition Quiz</title>
    <style>
        .setup-form {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            max-width: 400px;
        }
        input[type="number"] {
            width: 100px;
            padding: 5px;
            margin: 10px 0;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Welcome to Addition Quiz</h1>
    <div class="setup-form">
        <form action="quiz.jsp" method="get">
            <label for="questionCount">How many questions would you like? (1-20)</label><br>
            <input type="number" id="questionCount" name="questionCount" 
                   min="1" max="20" value="5" required><br>
            <input type="submit" value="Start Quiz">
        </form>
    </div>
</body>
</html>