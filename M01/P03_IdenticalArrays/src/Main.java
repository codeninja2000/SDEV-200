//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{

    public static void main(String[] args) {
// Uncomment this code to use this as a driver instead of inputting the elements manually
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
//
//        System.out.printf("a = b == %b%n", equals(a, b));
//        System.out.printf("a = c == %b%n", equals(a, c));
//        System.out.printf("b = c == %b%n", equals(b, c));

    }

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