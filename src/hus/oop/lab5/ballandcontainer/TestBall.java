package hus.oop.lab5.ballandcontainer;

public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(100, 100, 10, 5, 45); // Starting at (100, 100) with speed 5 and direction 45 degrees

        System.out.println(ball); // Print initial position and velocity

        ball.move(); // Move the ball by one step
        System.out.println(ball); // Print new position and velocity

        ball.reflectHorizontal(); // Reflect horizontally
        System.out.println(ball); // Print new position and velocity

        ball.reflectVertical(); // Reflect vertically
        System.out.println(ball); // Print new position and velocity
    }
}
