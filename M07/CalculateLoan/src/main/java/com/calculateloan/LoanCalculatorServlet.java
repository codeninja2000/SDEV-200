package com.calculateloan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * LoanCalculatorServlet handles the loan calculation requests.
 * It processes the form data submitted by the user, calculates
 * the monthly and total payments, and returns the results in HTML format.
 */
@WebServlet(name = "calculateLoanServlet", value = "/calculate-loan")
public class LoanCalculatorServlet extends HttpServlet {

    /**
     * Handles the HTTP POST request to calculate the loan.
     * @param request http request containing the loan parameters
     * @param response http response to send back the results
     * @throws ServletException servlet exception if an error occurs during processing
     * @throws IOException IO exception if an error occurs while writing the response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the form
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));

        // Create a loan object
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

        // Calculate monthly and total payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Set response content type
        response.setContentType("text/html");

        // Create the response HTML
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Loan Calculation Results</title>");
        out.println("<style>");
        out.println(".result-container { width: 300px; margin: 20px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }");
        out.println(".result-row { margin-bottom: 15px; }");
        out.println(".back-link { display: block; text-align: center; margin-top: 20px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result-container'>");
        out.println("<h2>Loan Calculation Results</h2>");
        out.println("<div class='result-row'>");
        out.println("<strong>Loan Amount:</strong> $" + String.format("%.2f", loanAmount));
        out.println("</div>");
        out.println("<div class='result-row'>");
        out.println("<strong>Annual Interest Rate:</strong> " + String.format("%.2f", annualInterestRate) + "%");
        out.println("</div>");
        out.println("<div class='result-row'>");
        out.println("<strong>Number of Years:</strong> " + numberOfYears);
        out.println("</div>");
        out.println("<div class='result-row'>");
        out.println("<strong>Monthly Payment:</strong> $" + String.format("%.2f", monthlyPayment));
        out.println("</div>");
        out.println("<div class='result-row'>");
        out.println("<strong>Total Payment:</strong> $" + String.format("%.2f", totalPayment));
        out.println("</div>");
        out.println("<a href='index.jsp' class='back-link'>Calculate Another Loan</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}