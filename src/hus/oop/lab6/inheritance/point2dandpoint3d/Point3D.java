package hus.oop.lab6.inheritance.point2dandpoint3d;

public class Point3D extends Point2D{
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float xyz[] = {super.getX(), super.getY(), z};
        return xyz;
    }

    public String toString(){
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
}
