package P02_RationalBigInteger;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    // Driver program to test Rational
    // The program creates two rational numbers, r1 and r2 from the user
    // and prints the results of r1 + r2, r1 - r2, r1 * r2, r1 / r2
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BigInteger numerator1 = BigInteger.ZERO;
        BigInteger numerator2 = BigInteger.ZERO;
        BigInteger denominator1 = BigInteger.ZERO;
        BigInteger denominator2 = BigInteger.ZERO;
        boolean done = false;
        do {
            try {
                System.out.println("Enter the first rational number (format: n d): ");
                numerator1 = input.nextBigInteger();
                denominator1 = input.nextBigInteger();
                Rational r1 = new Rational(numerator1, denominator1);

                System.out.println("Enter the second rational number (format: n d): ");
                numerator2 = input.nextBigInteger();
                denominator2 = input.nextBigInteger();
                Rational r2 = new Rational(numerator2, denominator2);

                done = true;

                System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
                System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
                System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
                System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
            } catch (IllegalArgumentException | NoSuchElementException | IllegalStateException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        } while (!done);


    }
}

