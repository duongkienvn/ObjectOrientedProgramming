package hus.oop.lab6.inheritance.pointandline;

public class TestPoint {
    public static void main(String[] args) {
        Point point1 = new Point(3, 4);

        // In ra thông tin của điểm
        System.out.println("Thông tin của điểm point1: " + point1.toString());

        // Lấy tọa độ x và y của điểm
        System.out.println("Tọa độ x của điểm point1: " + point1.getX());
        System.out.println("Tọa độ y của điểm point1: " + point1.getY());

        // Đặt tọa độ x và y mới cho điểm
        point1.setX(5);
        point1.setY(6);

        // In ra thông tin của điểm sau khi thay đổi
        System.out.println("Thông tin của điểm point1 sau khi thay đổi: " + point1.toString());

        // Đặt tọa độ x và y mới cho điểm
        point1.setXY(7, 8);

        // In ra thông tin của điểm sau khi thay đổi
        System.out.println("Thông tin của điểm point1 sau khi đặt tọa độ mới: " + point1.toString());
    }
}
