import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
        // Prompt for Credit card number
        long creditCardNumber = getCreditCardNumber(input);

        // Check for validity
        // Print validity results
        if (CreditCardValidator.isValid(creditCardNumber)) {
            System.out.println("Credit card number is valid!");
        } else {
            System.out.println("Credit card number is invalid!");
        }
    }

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