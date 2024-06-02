package hus.oop.lab6.inheritance.point2dandpoint3d;

public class TestPoint2D {
    public static void main(String[] args) {
        Point2D point2D1 = new Point2D();
        System.out.println("Default Point2D: " + point2D1.toString());

        Point2D point2D2 = new Point2D(3.0f, 4.0f);
        System.out.println("Custom Point2D: " + point2D2.toString());

        point2D1.setX(5.0f);
        point2D1.setY(6.0f);
        System.out.println("Modified Point2D: " + point2D1.toString());

        float[] coordinates2D = point2D1.getXY();
        System.out.println("Coordinates of point2D1: (" + coordinates2D[0] + ", " + coordinates2D[1] + ")");

        // Test Point3D
        Point3D point3D1 = new Point3D();
        System.out.println("Default Point3D: " + point3D1.toString());

        Point3D point3D2 = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Custom Point3D: " + point3D2.toString());

        point3D1.setX(4.0f);
        point3D1.setY(5.0f);
        point3D1.setZ(6.0f);
        System.out.println("Modified Point3D: " + point3D1.toString());

        point3D2.setXYZ(7.0f, 8.0f, 9.0f);
        System.out.println("Re-modified Point3D: " + point3D2.toString());

        float[] coordinates3D = point3D1.getXYZ();
        System.out.println("Coordinates of point3D1: (" + coordinates3D[0] + ", " + coordinates3D[1] + ", " + coordinates3D[2] + ")");
    }
}
