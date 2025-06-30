package P02_RationalBigInteger;

import java.math.BigInteger;
/**
 * Represents a rational number (fraction) using BigInteger for both numerator and
 * denominator. This class extends Number and implements Comparable<Rational>.
 * 
 * <p>This class provides:</p>
 * <ul>
 *   <li>Storage of rational numbers in their simplified form (reduced by GCD)</li>
 *   <li>Basic arithmetic operations (addition, subtraction, multiplication, division)</li>
 *   <li>Comparison between rational numbers</li>
 *   <li>Conversion to various numeric types (int, long, float, double)</li>
 *   <li>String representation in the form "numerator/denominator"</li>
 * </ul>
 * 
 * <p>Rational numbers are always stored in their reduced form, and the denominator
 * is always positive. If the rational number is negative, the sign is stored in
 * the numerator.</p>
 * 
 * @see Number
 * @see Comparable
 */
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
     * Construct a rational with the specified numerator and denominator
     */
    public Rational(BigInteger numerator, BigInteger denominator) throws IllegalArgumentException {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.abs().divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }
    // Construct a rational given a numerator and denominator of type long
    public Rational(long numerator, long denominator) throws IllegalArgumentException {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
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
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(secondRational.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(secondRational.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public Rational divide(Rational secondRational) {
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
    // Check if the other object is an instance of Rational
        if (!(other instanceof Rational)) {
            return false; // Not a Rational instance
        }
        return (this.subtract((Rational) (other))).getNumerator().equals(BigInteger.ZERO);
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