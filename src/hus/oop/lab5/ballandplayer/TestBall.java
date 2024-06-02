package hus.oop.lab5.ballandplayer;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(1.0f, 2.0f, 3.0f);

        // In ra tọa độ ban đầu của quả bóng
        System.out.println("Initial coordinates of the ball:");
        System.out.println("X: " + ball.getX() + ", Y: " + ball.getY() + ", Z: " + ball.getZ());

        // Thay đổi tọa độ của quả bóng
        ball.setXYZ(4.0f, 5.0f, 6.0f);

        // In ra tọa độ mới của quả bóng
        System.out.println("\nNew coordinates of the ball:");
        System.out.println("X: " + ball.getX() + ", Y: " + ball.getY() + ", Z: " + ball.getZ());

        // In ra thông tin của quả bóng
        System.out.println("\nBall information:");
        System.out.println(ball);
    }
}
