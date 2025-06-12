import java.util.Scanner;

// Driver program for CreditCardValidator
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long creditCardNumber = getCreditCardNumber(input);

        if (CreditCardValidator.isValid(creditCardNumber)) {
            System.out.println("Credit card number is valid!");
        } else {
            System.out.println("Credit card number is invalid!");
        }
    }

    // Function to handle credit card number input
    // Precondition: sc must point to an existing Scanner(System.in) object.
    // size must be an integer in the interval [13,16].
    // Postcondition: A (possibly invalid) credit card number is returned. This method
    // only verifies that the size of the number falls within a certain range, it does not do
    // any further validation checks.
    public static long getCreditCardNumber(Scanner sc) {
        int size;
        long cardNumber;
        do {
            System.out.print("Enter credit card number: ");
            while (!sc.hasNextLong()) {
                System.out.println("Please enter a number:");
                sc.next();
            }
            cardNumber = sc.nextLong();
            size = CreditCardValidator.getSize(cardNumber);
            if (size < 13 || size > 16)
                System.out.println("Credit card number must be 13-16 digits long.");
            //System.out.println("Size: " + size);
        } while (size < 13 || size > 16);
        return cardNumber;
    }
}