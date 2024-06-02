package hus.oop.lab4.shapes;

public class TestMyPolynomial {
    public static void main(String[] args) {
        MyPolynomial polynomial1 = new MyPolynomial(1.1, 2.2, 3.3);
        System.out.println("Polynomial 1: " + polynomial1);

        // Khởi tạo đa thức 2
        MyPolynomial polynomial2 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("Polynomial 2: " + polynomial2);

        // Kiểm tra bậc của đa thức
        System.out.println("Degree of polynomial 1: " + polynomial1.getDegree());
        System.out.println("Degree of polynomial 2: " + polynomial2.getDegree());

        // Tính giá trị đa thức tại x
        double x = 2.0;
        System.out.println("Value of polynomial 1 at x = " + x + ": " + polynomial1.evaluate(x));
        System.out.println("Value of polynomial 2 at x = " + x + ": " + polynomial2.evaluate(x));

        // Cộng đa thức
        MyPolynomial sum = polynomial1.add(polynomial2);
        System.out.println("Sum of polynomial 1 and polynomial 2: " + sum);

        // Nhân đa thức
        MyPolynomial product = polynomial1.multiply(polynomial2);
        System.out.println("Product of polynomial 1 and polynomial 2: " + product);

    }
}
