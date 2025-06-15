// Author: Grant Simpson
// Course: SDEV-200
// Date last updated: 06/11/2025
// Description: Driver program for the LengthConverter class
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Length Converter --- v1.0.0");
        Scanner input = new Scanner(System.in);
        printMenu();
        int choice = getInt(input);
        while (true) {
            switch (choice) {
                case 1:
                    convertMeterToFoot(input);
                    break;
                case 2:
                    convertFootToMeter(input);
                    break;
                case -1:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Option not recognized. Please try again.");
                    break;
            }
            printMenu();
            choice = getInt(input);
        }
    }

    private static void printMenu() {
        System.out.println("Conversions");
        System.out.println("1. Meter to foot");
        System.out.println("2. Foot to meter");
        System.out.print("Choose an option (enter -1 to quit): ");

    }

    // Function that repeatedly prompts for integer input until an integer is entered.
    // Precondition: sc is a valid Scanner object
    // Postcondition: an integer is returned
    private static int getInt(Scanner sc) {

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number");
            sc.next();
        }
        return sc.nextInt();
    }

    // Function that repeatedly prompts for double input until a double is entered.
    // Precondition: sc is a valid Scanner object
    // Postcondition: a double is returned
    private static double getDouble(Scanner sc) {

        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid number");
            sc.next();
        }
        return sc.nextDouble();
    }

    // Function to implement menu option #2 (foot-to-meter conversion)
    // Precondition: feet must be positive
    // Postcondition: If meter returns a negative number an error message is output and function terminated, otherwise
    // the converted units, in meters, are printed.
    private static void convertFootToMeter(Scanner sc) {
        System.out.print("Enter feet: ");
        double feet = getDouble(sc);
        double meter =  LengthConverter.footToMeter(feet);
        if (meter < 0) {
            System.out.println("Invalid input, feet must be positive.");
            return;
        }
        System.out.printf("Meters: %.2f%n", meter);


    }

    // Function to implement menu option #1 (meter-to-foot conversion)
    // Precondition: meter must be positive
    // Postcondition: If feet returns a negative number an error message is output and function terminated, otherwise
    // the converted units, in feet, are printed.
    private static void convertMeterToFoot(Scanner sc) {
        System.out.print("Enter meters: ");
        double meter = getDouble(sc);
        double feet =  LengthConverter.meterToFoot(meter);
        if (feet < 0) {
            System.out.println("Invalid input, meter must be positive.");
            return;
        }
        System.out.printf("Feet: %.2f%n", feet);
    }
}