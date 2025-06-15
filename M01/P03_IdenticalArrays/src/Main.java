import java.util.Scanner;

public class Main
{

    // The main program features two simple drivers: Interactive and Non-interactive.
    // Interactive - User can input values into the two arrays. Enabled (uncommented out) by default.
    // Non-interactive - A fixed set of values will be used to fill the arrays. Disabled (commented out) by default.
    // To switch drivers, comment out the Interactive Driver section and uncomment the Non-interactive Driver section.
    public static void main(String[] args) {

        /*************** INTERACTIVE DRIVER ***************/

        System.out.println("Identical Arrays - v1.0.0");
        Scanner input = new Scanner(System.in);
        int [][] arr1 = new int[3][3];
        int [][] arr2 = new int[3][3];
        char doContinue = 'y';

        while (doContinue == 'y') {
            System.out.print("Enter the first 3 x 3 array: ");
            get2dArray(arr1, input);
            System.out.print("Enter the second 3 x 3 array: ");
            get2dArray(arr2, input);

            String equalStat = equals(arr1, arr2) ? "is equal"  : "is not equal";
            System.out.printf("array 1 %s to array 2 %n", equalStat);

            System.out.print("Do you want to continue (y/n): ");
            doContinue = Character.toLowerCase(input.next().charAt(0));
        }



        /*************** NON-INTERACTIVE DRIVER ***************/

//        System.out.println("Identical Arrays - v1.0.0");
//        int[][] a =   {{1, 2, 1},
//                {2, 1, 2},
//                {1, 2, 1}};
//        int[][] b =   {{3, 3, 3},
//                {6, 6, 6},
//                {3, 1, 2}};
//        int[][] c =   {{1, 2, 1},
//                {2, 1, 2},
//                {1, 2, 1}};
//
//        System.out.printf("a = b == %b%n", equals(a, b));
//        System.out.printf("a = c == %b%n", equals(a, c));
//        System.out.printf("b = c == %b%n", equals(b, c));



    }
    // Method to get a 3 x 3 2d array from user.
    // The user can either enter a list of space separated characters or newline separated.
    // If there is excess input (greater than 9 elements), the input is left in the buffer. This means that technically,
    // although not recommended, one could enter both arrays in one line.
    public static void get2dArray(int[][] arr, Scanner input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input.hasNextInt()) {
                    arr[i][j] = input.nextInt();
                }
            }
        }
    }

    // Method to determine whether two 2d arrays are equal.
    // Two arrays, a[][] and b[][] are equal if a[i][j] == b[i][j] for every i and j.
    // The length is also checked because if two arrays differ in length they will never be equal,
    // so it is not necessary to continue checking for equality after such a discovery.
    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length)
            return false;

        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length)
                return false;
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }
}