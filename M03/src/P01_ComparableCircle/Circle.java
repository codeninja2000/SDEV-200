package P01_ComparableCircle;

/**
 * Represents a geometric circle with a specified radius. This class extends GeometricObject
 * and implements the Comparable interface for radius-based comparison between circles.
 * 
 * <p>The Circle class provides functionality to:</p>
 * <ul>
 *   <li>Calculate geometric properties (area, diameter, perimeter)</li>
 *   <li>Compare circles based on their radii</li>
 *   <li>Check equality between circle objects</li>
 *   <li>Get and set the radius value</li>
 * </ul>
 * 
 * <p>The class ensures proper comparison and equality checks through overridden
 * {@code compareTo} and {@code equals} methods. All calculations involving π use
 * the {@code Math.PI} constant for precision.</p>
 *
 * @see GeometricObject
 * @see Comparable
 */
// Create new class description
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

    // Implement compareTo
    // Returns a negative integer, zero, or a positive integer if
    // the object is less than, equal to, or greater than otherCircle, respectively.
    @Override
    public int compareTo(Circle otherCircle) {
        return Double.compare(this.radius, otherCircle.radius);
    }

    // Override equals method
    // Returns true if the two circles have the same radius or if "this" and "o"
    // reference the same object, otherwise returns false.
    @Override
    public boolean equals(Object o) {
        if (o == null) throw new NullPointerException();
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(this.radius, circle.radius) == 0;
    }

    // Return radius
    public double getRadius() {
        return radius;
    }

    // Set a new radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override /** Return area */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // Return diameter
    public double getDiameter() {
        return 2 * radius;
    }

    @Override // Return perimeter
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // Print the circle info
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }
}