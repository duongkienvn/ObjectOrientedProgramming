package hus.oop.lab5.ballandplayer;

public class TestPlayer {
    public static void main(String[] args) {
        Player player = new Player(1, 0, 0);

        // Kiểm tra phương thức getX(), getY(), getZ() và setXYZ()
        System.out.println("Initial position of the player:");
        System.out.println("X: " + player.getX() + ", Y: " + player.getY() + ", Z: " + player.getZ());
        player.setXYZ(10, 20, 30);
        System.out.println("New position of the player:");
        System.out.println("X: " + player.getX() + ", Y: " + player.getY() + ", Z: " + player.getZ());

        // Kiểm tra phương thức move(float xDisp, float yDisp)
        System.out.println("\nMove the player:");
        player.move(5, 5);
        System.out.println("New position after moving:");
        System.out.println("X: " + player.getX() + ", Y: " + player.getY() + ", Z: " + player.getZ());

        // Kiểm tra phương thức jump(float zDisp)
        System.out.println("\nJump the player:");
        player.jump(10);
        System.out.println("New position after jumping:");
        System.out.println("X: " + player.getX() + ", Y: " + player.getY() + ", Z: " + player.getZ());

        // Tạo một đối tượng quả bóng mới
        Ball ball = new Ball(5, 5, 5);

        // Kiểm tra phương thức near(Ball ball)
        System.out.println("\nCheck if the player is near the ball:");
        System.out.println("Is player near the ball? " + player.near(ball));

        // Kiểm tra phương thức kick(Ball ball)
        System.out.println("\nKick the ball:");
        player.kick(ball);
        System.out.println("New position of the ball after kicking:");
        System.out.println(ball);
    }
}
