public class RegularPolygon {
    private int n = 3; // # of sides
    private double side = 1; // length of sides
    private double x = 0; // x-coordinate of center
    private double y = 0; // y-coordinate of center

    public RegularPolygon() {}

    public RegularPolygon(int n, double side) {
        if (n < 3) {
            throw new IllegalArgumentException("Polygons must have at least 3 sides.");
        }
        if (side < 1) {
            throw new IllegalArgumentException("Sides must be at least 1.");
        }
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this(n, side);
        this.x = x;
        this.y = y;
    }

    public int getN() {

        return n;
    }

    public void setN(int n) {
        if (n < 3) {
            throw new IllegalArgumentException("Polygons must have at least 3 sides.");
        }
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side < 1) {
            throw new IllegalArgumentException("Sides must be at least 1.");
        }
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    @Override
    public String toString() {
        return String.format("Perimeter: %.2f \nArea: %.2f\n", getPerimeter(), getArea());
    }
}
