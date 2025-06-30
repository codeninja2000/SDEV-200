package P02_RationalBigInteger;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /**
     * Construct a rational with default properties
     */
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.abs().divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }
    public Rational(long numerator, long denominator) {
        BigInteger n = BigInteger.valueOf(numerator);
        BigInteger d = BigInteger.valueOf(denominator);
        BigInteger gcd = gcd(n, d);
        this.numerator = n.abs().divide(gcd);
        this.denominator = d.abs().divide(gcd);
    }

    /**
     * Find GCD of two numbers
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {

        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        return n1.gcd(n2);
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Add a rational number to this rational
     */
    public Rational add(Rational secondRational) {
//        long n = numerator * secondRational.getDenominator() +
//                denominator * secondRational.getNumerator();
//        long d = denominator * secondRational.getDenominator();
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(secondRational.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
//        long n = numerator * secondRational.getDenominator()
//                - denominator * secondRational.getNumerator();
//        long d = denominator * secondRational.getDenominator();
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(secondRational.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational) {
//        long n = numerator * secondRational.getNumerator();
//        long d = denominator * secondRational.getDenominator();
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational) {
//        long n = numerator * secondRational.getDenominator();
//        long d = denominator * secondRational.numerator;
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override // Override toString()
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((Rational) (other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
        return this.subtract(o).getNumerator().compareTo(BigInteger.ZERO);
    }
}