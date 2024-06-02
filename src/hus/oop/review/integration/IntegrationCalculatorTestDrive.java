package hus.oop.review.integration;

public class IntegrationCalculatorTestDrive {
    public static void main(String[] args) {
        testArrayPolynomial();
        testListPolynomial();
        testIntegrationCalculator();
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
    }

    public static void testArrayPolynomial() {
        System.out.println("TestArrayPolynomial: ");
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.append(1);
        poly1.append(2);
        poly1.append(-1);
        poly1.append(0);
        poly1.append(-9);
        System.out.println("Poly1: " + poly1.toString());

        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.append(6);
        poly2.append(8);
        poly2.append(-2);
        poly2.append(9);
        poly2.append(-4);
        System.out.println("Poly2: " + poly2.toString());

        System.out.println("Poly1 + Poly2: " + poly1.plus(poly2).toString());
        System.out.println("Poly1 - Poly2: " + poly1.minus(poly2).minus(poly2).toString());
        System.out.println("Poly1 * Poly2: " + poly1.multiply(poly2).toString());

        poly1.set(10, 8);
        System.out.println("Now Poly1: " + poly1.toString());
        System.out.println("Poly1(8): " + poly1.evaluate(8));
        System.out.println("-----------------------------------------------------------------");
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
    }

    public static void testListPolynomial() {
        System.out.println("TestListPolynomial: ");
        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(1);
        poly1.append(2);
        poly1.append(-1);
        poly1.append(0);
        poly1.append(-9);
        System.out.println("Poly1: " + poly1.toString());

        ListPolynomial poly2 = new ListPolynomial();
        poly2.append(6);
        poly2.append(8);
        poly2.append(-2);
        poly2.append(9);
        poly2.append(-4);
        System.out.println("Poly2: " + poly2.toString());

        System.out.println("Poly1 + Poly2: " + poly1.plus(poly2).toString());
        System.out.println("Poly1 - Poly2: " + poly1.minus(poly2).minus(poly2).toString());
        System.out.println("Poly1 * Poly2: " + poly1.multiply(poly2).toString());

        poly1.set(10, 8);
        System.out.println("Now Poly1: " + poly1.toString());
        System.out.println("Poly1(8): " + poly1.evaluate(8));
        System.out.println("-----------------------------------------------------------------");
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
    }

    public static void testIntegrationCalculator() {
        ListPolynomial poly1 = new ListPolynomial();
        poly1.append(1);
        poly1.append(2);
        poly1.append(-1);
        poly1.append(0);
        poly1.append(-9);

        Integrator integrator1 = new MidpointRule(0.000001, 10000);
        IntegrationCalculator integrationCalculator = new IntegrationCalculator(integrator1, poly1);
        System.out.println("Poly1: " + poly1.toString());
        System.out.println("MidpointRule: " + integrationCalculator.integrate(4, 5));
        System.out.println();


        integrationCalculator.setIntegrator(new SimpsonRule(0.000001, 10000));
        System.out.println("Poly1: " + poly1.toString());
        System.out.println("SimpsonRule: " + integrationCalculator.integrate(-4, 5));
        System.out.println();

        integrationCalculator.setIntegrator(new TrapezoidRule(0.000001, 10000));
        System.out.println("Poly1: " + poly1.toString());
        System.out.println("TrapezoidRule: " + integrationCalculator.integrate(-6, 0));
        /*
         TODO

         - Tạo một đa thức.
         - Viết demo chương trình tính tích phân xác định của đa thức theo các phương pháp đã cho (MidpointRule, TrapezoidRule, SimpsonRule) sử dụng
           IntegrationCalculator. Các phương pháp tính tích phân có thể thay đổi ở thời gian chạy chương trình.
         - In ra thông tin phương pháp sử dụng, đa thức, và giá trị tích phân của đa thức.
         */
    }
}
