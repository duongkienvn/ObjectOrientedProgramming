package hus.oop.lab5.ballandplayer;

public class Player {
    private int number;
    private float x, y;
    private float z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(float xDisp, float yDisp) {
        x += xDisp;
        y += yDisp;
    }

    public void jump(float zDisp) {
        z += zDisp;
    }

    public boolean near(Ball ball) {
        float distance = (float) Math.sqrt(Math.pow(this.x - ball.getX(), 2)
                + Math.pow(this.y - ball.getY(), 2)
                + Math.pow(this.z - ball.getZ(), 2));
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            float newZ = ball.getZ() + 10;
            ball.setZ(newZ);

            float newX = ball.getX() + 5;
            float newY = ball.getY() + 5;
            ball.setXYZ(newX, newY, newZ);
        }
    }
}
