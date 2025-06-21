package P02_Triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // get side1..side3
        double side1 = getSide(input, 1);
        double side2 = getSide(input, 2);
        double side3 = getSide(input, 3);
        Triangle triangle = new Triangle(side1, side2, side3);
        // get color
        System.out.print("Enter color: ");
        input.nextLine();
        String color = input.nextLine();
        triangle.setColor(color);
        // get filled
        triangle.setFilled(getFill(input));
        // display area, perimeter, color, isFilled
        System.out.printf("Perimeter: %.2f%n", triangle.getPerimeter());
        System.out.printf("Area: %.2f%n", triangle.getArea());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("isFilled: " + triangle.isFilled());
    }
    // Returns true if user chose "y" and no otherwise
    private static boolean getFill(Scanner input) {
        System.out.print("fill? (y/n): ");
        String fill = (input.next().charAt(0) + "").toLowerCase();

        while (!fill.equals("y") && !fill.equals("n")) {
            System.out.println("Invalid input. Enter y or n.");
//            System.out.print("fill? (y/n): ");
            fill = (input.next().charAt(0) + "").toLowerCase();
        }

        return fill.equals("y");
    }

    private static double getSide(Scanner sc, int sideNumber) {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
        System.out.print("Enter side " + sideNumber + ": ");
            try {
                if (sc.hasNextDouble()) {
                    input = sc.nextDouble();
                    if (input <= 0) {
                        System.out.println("Invalid input");
                        sc.next();
                    } else {
                        validInput = true;
                    }
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input");
                sc.next();
            }
        }
        return input;

    }
}
