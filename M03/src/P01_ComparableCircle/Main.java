package P01_ComparableCircle;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);
        Circle circle3 = new Circle(5.0);
        Circle circle4 = null;
        Circle circle5 = circle1;

        System.out.println("""
                Circle circle1 = new Circle(5);
                Circle circle2 = new Circle(10);
                Circle circle3 = new Circle(5.0);
                Circle circle4 = null;
                Circle circle5 = circle1""");

        System.out.println("circle1.compareTo(circle2) = " + circle1.compareTo(circle2));

        System.out.println("circle1.compareTo(circle3) = " + circle1.compareTo(circle3));

        try {
            System.out.println("circle1.compareTo(circle4) = " + circle1.compareTo(circle4));
        } catch (NullPointerException e) {
            System.out.println("circle1.compareTo(circle4) = " + e.getMessage());
        }

        System.out.println("circle1.compareTo(circle5) = " + circle1.compareTo(circle5));
    }
}
