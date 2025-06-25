package P01_ComparableCircle;

/**
 * The Circle class represents a geometric circle with a specified radius.
 * It extends GeometricObject and implements the Comparable interface to allow
 * comparison of Circle objects based on their radius.
 * Provides methods to calculate area, diameter, and perimeter, as well as
 * to compare and check equality with other Circle instances.
 */
public class Circle extends GeometricObject
    implements Comparable<Circle> {

    private double radius; // The radius of the circle

    // Construct a default circle
    public Circle() {
    }

    // Construct a circle with a specified radius
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override // Implement compareTo
    // Returns a negative integer, zero, or a positive integer if
    // the object is less than, equal to, or greater than otherCircle, respectively.
    public int compareTo(Circle otherCircle) {
        return Double.compare(this.radius, otherCircle.radius);
    }

    // Override equals method
    // Returns true if the two circles have the same radius or if "this" and "o"
    // reference the same object, otherwise returns false.
    @Override // Implement equals
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException();
        // If object is compared to itself, return true
        if (this == o) return true;
        // If object is null or the two object's classes differ return false
        if (getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        // If compare indicates equality (returning 0), return true
        return Double.compare(this.radius, circle.radius) == 0;
    }

    /** Return radius */
    public double getRadius() {
        return radius;
    }

    /** Set a new radius */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Return diameter */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override /** Return perimeter */
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* Print the circle info */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }
}