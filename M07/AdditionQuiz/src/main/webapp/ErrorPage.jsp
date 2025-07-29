
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <style>
        .error-container {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ff4444;
            border-radius: 5px;
            background-color: #ffe6e6;
        }
        .back-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h2>Error Occurred</h2>
    <p>${errorMessage}</p>
    <a href="quiz.jsp" class="back-button">Back to Quiz</a>
</div>
</body>
</html>