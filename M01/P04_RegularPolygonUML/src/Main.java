public class Main {
    public static void main(String[] args) {

        RegularPolygon regularPolygon = new RegularPolygon();
        RegularPolygon regularPolygon2 = new RegularPolygon(6, 4);
        RegularPolygon regularPolygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.printf("Ctor #1 - RegularPolygon():%n%s", regularPolygon.toString());
        System.out.printf("Ctor #2 - RegularPolygon(6, 4):%n%s", regularPolygon2.toString());
        System.out.printf("Ctor #3 - RegularPolygon(10, 4, 5.6, 7.8):%n%s", regularPolygon3.toString());
    }

}

