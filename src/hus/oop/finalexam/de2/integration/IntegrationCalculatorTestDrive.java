package hus.oop.finalexam.de2.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        System.out.println("Test ArrayPolynomial:");
        testArrayPolynomial();
        System.out.println("\nTest ListPolynomial:");
        testListPolynomial();
        System.out.println("\nTest IntegrationCalculator:");
        testIntegrationCalculator();
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(1).append(2).append(3); // 1 + 2x + 3x^2

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.append(3).append(4).append(5); // 3 + 4x + 5x^2

        ArrayPolynomial sum = new ArrayPolynomial();
        sum = poly1.plus(poly2); // (1 + 2x + 3x^2) + (3 + 4x + 5x^2)

        ArrayPolynomial difference = new ArrayPolynomial();
        difference = poly1.minus(poly2); // (1 + 2x + 3x^2) - (3 + 4x + 5x^2)

        ArrayPolynomial product = new ArrayPolynomial();
        product = poly1.multiply(poly2); // (1 + 2x + 3x^2) * (3 + 4x + 5x^2)

        System.out.println("ArrayPolynomial Test:");
        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Evaluation of poly1 at x=2: " + poly1.evaluate(2));
        System.out.println();
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(1).append(2).append(3); // 1 + 2x + 3x^2

        ListPolynomial poly2 = new ListPolynomial();
        poly2.append(3).append(4).append(5); // 3 + 4x + 5x^2

        ListPolynomial sum = new ListPolynomial();
        sum = poly1.plus(poly2); // (1 + 2x + 3x^2) + (3 + 4x + 5x^2)

        ListPolynomial difference = new ListPolynomial();
        difference = poly1.minus(poly2); // (1 + 2x + 3x^2) - (3 + 4x + 5x^2)

        ListPolynomial product = new ListPolynomial();
        product = poly1.multiply(poly2); // (1 + 2x + 3x^2) * (3 + 4x + 5x^2)

        System.out.println("ListPolynomial Test:");
        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Evaluation of poly1 at x=2: " + poly1.evaluate(2));
        System.out.println();
    }

    public static void testIntegrationCalculator() {
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
        ArrayPolynomial polynomial = new ArrayPolynomial();
        polynomial.append(1).append(2).append(3);

        // Create integration calculator
        IntegrationCalculator calculator = new IntegrationCalculator(polynomial);

        // Define integration bounds
        double lowerBound = 0;
        double upperBound = 4;

        // Test Midpoint Rule
        Integrator midpointRule = new MidpointRule(0.0001, 100);
        calculator.setIntegrator(midpointRule);
        double midpointResult = calculator.integrate(lowerBound, upperBound);

        System.out.println("Using Midpoint Rule:");
        System.out.println("Polynomial: " + polynomial);
        System.out.println("Integral Value: " + midpointResult);
        System.out.println();

        // Test Trapezoid Rule
        Integrator trapezoidRule = new TrapezoidRule(0.0001, 100);
        calculator.setIntegrator(trapezoidRule);
        double trapezoidResult = calculator.integrate(lowerBound, upperBound);

        System.out.println("Using Trapezoid Rule:");
        System.out.println("Polynomial: " + polynomial);
        System.out.println("Integral Value: " + trapezoidResult);
        System.out.println();

        // Test Simpson's Rule
        Integrator simpsonRule = new SimpsonRule(0.0001, 100);
        calculator.setIntegrator(simpsonRule);
        double simpsonResult = calculator.integrate(lowerBound, upperBound);

        System.out.println("Using Simpson's Rule:");
        System.out.println("Polynomial: " + polynomial);
        System.out.println("Integral Value: " + simpsonResult);
    }
}
