public class CreditCardValidator {
    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        return true;
    }

    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;

        int size = String.valueOf(number).length();

        for (int i = 1; i <= size; i++) {
            // If our current pos is even
            if (i % 2 == 0) {
                // Get digit
                // Double digit
                // Get, double,and normalize even position digits and sum them
                sum += getDigit((int)(number % 10) * 2);
                System.out.printf("sum: %d%n", sum);
            } else {
                // Sum odd position digits
                sum += (int)(number % 10);
            }
            // Advanced to next digit
            number = number / 10;
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {

        return (number / 10) + (number % 10);
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        return 0;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        return true;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        return String.valueOf(d).length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {

        String numberCpyStr = String.valueOf(number);
        if (numberCpyStr.length() > k) {
            return Long.parseLong(numberCpyStr.substring(0, k));
        }
        else
            return number;
    }
}
