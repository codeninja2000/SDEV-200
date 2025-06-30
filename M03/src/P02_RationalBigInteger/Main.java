package P02_RationalBigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational r3 = new Rational(BigInteger.valueOf(1), BigInteger.valueOf(4));
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r3: " + r3);
        System.out.println("r1 + r2: " + r1.add(r2));
        System.out.println("r1 - r2: " + r1.subtract(r2));
        System.out.println("r1 * r2: " + r1.multiply(r2));
        System.out.println("r1 / r2: " + r1.divide(r2));

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first rational number (format: n d): ");
        BigInteger numerator1 = input.nextBigInteger(); // TODO add exception handling
        BigInteger denominator1 = input.nextBigInteger(); // TODO add exception handling

        System.out.println("Enter the second rational number (format: n d): ");
        BigInteger numerator2 = input.nextBigInteger(); // TODO add exception handling
        BigInteger denominator2 = input.nextBigInteger(); // TODO add exception handling

    }
}
