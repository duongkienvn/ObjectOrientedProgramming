package hus.oop.lab4.composition.mypoint;

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(3, 4);
        System.out.println(point1.distance(5, 6));

        point1.setX(8);
        point1.setY(6);

        System.out.println("x is: " + point1.getX());
        System.out.println("y is: " + point1.getY());
        point1.setXY(3, 0); // Test setXY()
        System.out.println(point1.getXY()[0]); // Test getXY()
        System.out.println(point1.getXY()[1]);
        System.out.println(point1);
        MyPoint point2 = new MyPoint(0, 4); // Test another constructor
        System.out.println(point2);

        // Testing the overloaded methods distance()
        System.out.println(point1.distance(point2)); // which version?
        System.out.println(point2.distance(point1)); // which version?
        System.out.println(point1.distance(5, 6)); // which version?
        System.out.println(point1.distance());


        MyPoint points[] = new MyPoint[10];
        for(int i = 0; i < points.length; i++){
            points[i] = new MyPoint(i + 1, i + 1);
        }
        for(int i = 0; i < points.length; i++){
            System.out.println(points[i].toString());
        }
    }
}
