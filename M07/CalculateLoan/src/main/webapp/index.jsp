<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Loan Calculator</title>
    <style>
        .form-container {
            width: 300px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="number"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Loan Calculator</h2>
    <form action="calculate-loan" method="post">
        <div class="form-group">
            <label for="loanAmount">Loan Amount:</label>
            <input type="number" id="loanAmount" name="loanAmount" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="annualInterestRate">Annual Interest Rate (%):</label>
            <input type="number" id="annualInterestRate" name="annualInterestRate" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="numberOfYears">Number of Years:</label>
            <input type="number" id="numberOfYears" name="numberOfYears" required>
        </div>
        <input type="submit" value="Compute Loan Payment">
    </form>
</div>
</body>
</html>