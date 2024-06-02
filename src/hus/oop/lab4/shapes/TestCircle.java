package hus.oop.lab4.shapes;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("The circle has radius of "
                + circle1.getRadius() + " and area of " + circle1.getArea ( ));

        Circle circle2 = new Circle(2.0);
        System.out.println("The circle has radius of "
                + circle2.getRadius() + " and area of " + circle2.getArea ( ));

        Circle circle4 = new Circle();
        circle4.setRadius(5.5);
        System.out.println("radius is: " + circle4.getArea());

        circle4.setColor("green");
        System.out.println("color is: " + circle4.getColor());

        Circle circle5 = new Circle(5.5);
        System.out.println(circle5.toString());

        Circle circle6 = new Circle(6.6);
        System.out.println(circle6.toString());
        System.out.println(circle6);

        Circle circle7 = new Circle();
        System.out.println(circle7);
        System.out.println("radius is: " + circle7.getRadius());

        System.out.printf("area is: %.2f%n", circle7.getArea());
        System.out.printf("circumference is: %.2f%n", circle7.getCircumference());



    }
}
