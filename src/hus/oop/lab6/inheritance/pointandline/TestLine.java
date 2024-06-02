package hus.oop.lab6.inheritance.pointandline;

public class TestLine {
    public static void main(String[] args) {
        // Tạo các đối tượng Line bằng cách tạo các đối tượng Point trước
        Point beginPoint = new Point(1, 2);
        Point endPoint = new Point(4, 6);

        // Tạo đối tượng Line từ các điểm đã tạo
        Line line1 = new Line(beginPoint, endPoint);

        // Hiển thị thông tin của Line
        System.out.println("Thông tin của line1: " + line1.toString());

        // Lấy các tọa độ của đầu và cuối của đường thẳng
        System.out.println("Tọa độ của điểm bắt đầu của line1: (" + line1.getBeginX() + ", " + line1.getBeginY() + ")");
        System.out.println("Tọa độ của điểm kết thúc của line1: (" + line1.getEndX() + ", " + line1.getEndY() + ")");

        // Đặt các tọa độ mới cho đầu và cuối của đường thẳng
        line1.setBeginXY(0, 0);
        line1.setEndXY(3, 5);

        // Hiển thị thông tin của Line sau khi thay đổi
        System.out.println("Thông tin của line1 sau khi thay đổi: " + line1.toString());

        // In ra độ dài và góc nghiêng của đường thẳng
        System.out.println("Độ dài của line1: " + line1.getLength());
        System.out.println("Góc nghiêng của line1 (radian): " + line1.getGradient());
    }
}
