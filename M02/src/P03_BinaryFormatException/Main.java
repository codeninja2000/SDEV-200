package P03_BinaryFormatException;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String binaryNumber;
        int decimalNumber;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Binary Number (enter -1 to quit): ");
        binaryNumber = input.nextLine();
        while (!binaryNumber.equals("-1")) {
            try {
                decimalNumber = bin2dec(binaryNumber);
                System.out.println("Decimal Number: " + decimalNumber);
            } catch (BinaryFormatException bfe) {
                System.out.println("Error: " + bfe.getMessage());
            }
            System.out.println("Enter Binary Number (enter -1 to quit): ");
            binaryNumber = input.nextLine();
        }

    }

    /**
     * Method to convert a binary string to a decimal number
     * @param bin binary string to convert to a decimal number
     * @return decimal number
     */
    public static int bin2dec(String bin) {
       if (!isValidBinary(bin)) {
           throw new BinaryFormatException("Invalid binary number");
        }
       BigInteger dec = new BigInteger(bin, 2);
       return dec.intValue();

    }

    /**
     * Method to validate binary strings
     * @param num candidate binary string
     * @return false if num is not a valid binary string and true otherwise
     */
    public static boolean isValidBinary(String num) {
        for (char c : num.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
}
