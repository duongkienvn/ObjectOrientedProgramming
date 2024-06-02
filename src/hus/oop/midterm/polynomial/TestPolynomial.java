package hus.oop.midterm.polynomial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPolynomial {
    public static void main(String[] args) {
        /*
         TODO

         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        testArrayPolynomial();
//        testListPolynomial();
//        testRootSolver();
//
//        String path = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2\\" +
//                "src\\hus\\oop\\examination\\polynomial\\DuongCongKien_23001895_MyList.txt";
//        saveToFile(path);
    }

    public static void testArrayPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial arrayPolynomial = new ArrayPolynomial();
        arrayPolynomial.append(1);
        arrayPolynomial.append(3);
        arrayPolynomial.append(8);
        arrayPolynomial.append(7);

        arrayPolynomial.set(10, 2);
        System.out.println(arrayPolynomial);

        ArrayPolynomial anotherPolynomial = new ArrayPolynomial();
        anotherPolynomial.append(3);
        anotherPolynomial.append(5);
        anotherPolynomial.append(7);
        System.out.println(anotherPolynomial);

        ArrayPolynomial sum = arrayPolynomial.plus(anotherPolynomial);
        System.out.println(sum);

        ArrayPolynomial difference = arrayPolynomial.minus(anotherPolynomial);
        System.out.println(difference);

        ArrayPolynomial product = arrayPolynomial.multiply(anotherPolynomial);
        System.out.println(product);

        double x = 2;
        double value = arrayPolynomial.evaluate(x);
        System.out.println(value);
    }

    public static void testArrayPolynomial(PrintWriter printWriter) {
        /*
         TODO

         - Viết chương trình test các chức năng của ArrayPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ArrayPolynomial arrayPolynomial = new ArrayPolynomial();
        arrayPolynomial.append(1);
        arrayPolynomial.append(3);
        arrayPolynomial.append(8);
        arrayPolynomial.append(7);

        arrayPolynomial.set(10, 2);
        printWriter.println(arrayPolynomial);

        ArrayPolynomial anotherPolynomial = new ArrayPolynomial();
        anotherPolynomial.append(3);
        anotherPolynomial.append(5);
        anotherPolynomial.append(7);
        printWriter.println(anotherPolynomial);

        ArrayPolynomial sum = arrayPolynomial.plus(anotherPolynomial);
        printWriter.println(sum);

        ArrayPolynomial difference = arrayPolynomial.minus(anotherPolynomial);
        printWriter.println(difference);

        ArrayPolynomial product = arrayPolynomial.multiply(anotherPolynomial);
        printWriter.println(product);

        double x = 2;
        double value = arrayPolynomial.evaluate(x);
        printWriter.println(value);
    }

    public static void testListPolynomial() {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial listPolynomial = new ListPolynomial();
        listPolynomial.append(1);
        listPolynomial.append(3);
        listPolynomial.append(8);
        listPolynomial.append(7);

        listPolynomial.set(10, 2);
        System.out.println(listPolynomial);

        ListPolynomial anotherPolynomial = new ListPolynomial();
        anotherPolynomial.append(3);
        anotherPolynomial.append(5);
        anotherPolynomial.append(7);
        System.out.println(anotherPolynomial);

        ListPolynomial sum = listPolynomial.plus(anotherPolynomial);
        System.out.println(sum);

        ListPolynomial difference = listPolynomial.minus(anotherPolynomial);
        System.out.println(difference);

        ListPolynomial product = listPolynomial.multiply(anotherPolynomial);
        System.out.println(product);

        double x = 2;
        double value = listPolynomial.evaluate(x);
        System.out.println(value);
    }

    public static void testListPolynomial(PrintWriter printWriter) {
        /*
         TODO

         - Viết chương trình test các chức năng của ListPolynomial (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         */
        ListPolynomial listPolynomial = new ListPolynomial();
        listPolynomial.append(1);
        listPolynomial.append(3);
        listPolynomial.append(8);
        listPolynomial.append(7);

        listPolynomial.set(10, 2);
        printWriter.println(listPolynomial);

        ListPolynomial anotherPolynomial = new ListPolynomial();
        anotherPolynomial.append(3);
        anotherPolynomial.append(5);
        anotherPolynomial.append(7);
        printWriter.println(anotherPolynomial);

        ListPolynomial sum = listPolynomial.plus(anotherPolynomial);
        printWriter.println(sum);

        ListPolynomial difference = listPolynomial.minus(anotherPolynomial);
        printWriter.println(difference);

        ListPolynomial product = listPolynomial.multiply(anotherPolynomial);
        printWriter.println(product);

        double x = 2;
        double value = listPolynomial.evaluate(x);
        printWriter.println(value);
    }

    public static void testRootSolver() {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */

        ListPolynomial listPolynomial = new ListPolynomial();
        listPolynomial.append(4);
        listPolynomial.append(-7);
        listPolynomial.append(-2);
        listPolynomial.append(1);

        RootSolver bisectionSolver = new BisectionSolver(0.0001, 100);
        RootSolver secentSolver = new SecantSolver(0.0001, 100);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(0.0001, 100);

        PolynomialRootFinding rootFinding = new PolynomialRootFinding(listPolynomial);

        rootFinding.setRootSolver(bisectionSolver);
        double rootBisection = rootFinding.solve(0, 5);

        rootFinding.setRootSolver(secentSolver);
        double rootSecant = rootFinding.solve(0, 5);

        rootFinding.setRootSolver(newtonRaphsonSolver);
        double rootNewton = rootFinding.solve(0, 5);

        System.out.println("Phương pháp Bisection:");
        System.out.println("Đa thức: " + listPolynomial);
        System.out.println("Nghiệm: " + rootBisection);

        System.out.println("\nPhương pháp Newton-Raphson:");
        System.out.println("Đa thức: " + listPolynomial);
        System.out.println("Nghiệm: " + rootNewton);

        System.out.println("\nPhương pháp Secant:");
        System.out.println("Đa thức: " + listPolynomial);
        System.out.println("Nghiệm: " + rootSecant);
    }

    public static void testRootSolver(PrintWriter printWriter) {
        /*
         TODO

         - Tạo đa thức có nghiệm trong khoảng [a, b] nào đó.
         - Viết chương trình tìm nghiệm của đa thức theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           PolynomialRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, đa thức, và nghiệm của đa thức.
         */

        ListPolynomial listPolynomial = new ListPolynomial();
        listPolynomial.append(4);
        listPolynomial.append(-7);
        listPolynomial.append(-2);
        listPolynomial.append(1);

        RootSolver bisectionSolver = new BisectionSolver(0.0001, 100);
        RootSolver secentSolver = new SecantSolver(0.0001, 100);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(0.0001, 100);

        PolynomialRootFinding rootFinding = new PolynomialRootFinding(listPolynomial);

        rootFinding.setRootSolver(bisectionSolver);
        double rootBisection = rootFinding.solve(0, 5);

        rootFinding.setRootSolver(secentSolver);
        double rootSecant = rootFinding.solve(0, 5);

        rootFinding.setRootSolver(newtonRaphsonSolver);
        double rootNewton = rootFinding.solve(0, 5);

        printWriter.println("Phương pháp Bisection:");
        printWriter.println("Đa thức: " + listPolynomial);
        printWriter.println("Nghiệm: " + rootBisection);

        printWriter.println("\nPhương pháp Newton-Raphson:");
        printWriter.println("Đa thức: " + listPolynomial);
        printWriter.println("Nghiệm: " + rootNewton);

        printWriter.println("\nPhương pháp Secant:");
        printWriter.println("Đa thức: " + listPolynomial);
        printWriter.println("Nghiệm: " + rootSecant);
    }

    public static void saveToFile(String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
            printWriter.write("testListPolynomial:\n");
            testListPolynomial(printWriter);
            printWriter.write("testArrayPolynomial:\n");
            testArrayPolynomial(printWriter);
            printWriter.write("testRootSolver:\n");
            testRootSolver(printWriter);
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
