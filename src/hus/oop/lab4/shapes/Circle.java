package hus.oop.lab4.shapes;

import org.w3c.dom.ls.LSOutput;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        radius = 1.0;
        color = "red";
    }
    public Circle(double r){
       radius = r;
       color = "red";
    }

    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }

    public Circle(double r, String c){
        radius = r;
        color = c;
    }
    public String getColor(){
        return color;
    }

    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public void setColor(String newColor){
        color = newColor;
    }

    public double getCircumference(){
        return 2 * radius * Math.PI;
    }
    public String toString(){
        return "Circle[radius = " + radius + " color = " + color + "]";
    }






}
