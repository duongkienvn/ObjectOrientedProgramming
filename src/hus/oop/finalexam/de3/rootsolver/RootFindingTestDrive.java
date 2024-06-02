package hus.oop.finalexam.de3.rootsolver;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /*
         TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        AbstractFunction sinFunction = new UnivariateRealFunction();
        UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(sinFunction);

        System.out.println("Function: x * sin(x) - 3");
        System.out.println("Interval: [12, 14]");
        printRootSolver(rootFinding);

        AbstractFunction cosFunction = new AbstractFunction() {
            @Override
            public double evaluate(double x) {
                return MyMath.cos(x) * x - 3;
            }
        };
        rootFinding.setPoly(cosFunction);
        System.out.println("\nFunction: x * cos(x) - 3");
        System.out.println("Interval: [12, 14]");
        printRootSolver(rootFinding);

        AbstractFunction exprFunction = new AbstractFunction() {
            MyMath math = new MyMath();
            @Override
            public double evaluate(double x) {
                return math.exp(x) * x - 3;
            }
        };
        rootFinding.setPoly(exprFunction);
        System.out.println("\nFunction: x * exp(x) - 3");
        System.out.println("Interval: [12, 14]");
        printRootSolver(rootFinding);

        AbstractFunction lnFunction = new AbstractFunction() {
            MyMath math = new MyMath();
            @Override
            public double evaluate(double x) {
                return math.ln(x) * x - 3;
            }
        };
        rootFinding.setPoly(lnFunction);
        System.out.println("\nFunction: x * ln(x) - 3");
        System.out.println("Interval: [12, 14]");
        printRootSolver(rootFinding);
    }

    public static void printRootSolver(UnivariateRealRootFinding rootFinding) {
        RootSolver bisectionSolver = new BisectionSolver(1e-6, 1000);
        RootSolver secantSolver = new SecantSolver(1e-6, 1000);
        RootSolver newtonRaphsonSolver = new NewtonRaphsonSolver(1e-6, 1000);

        rootFinding.setRootSolver(bisectionSolver);
        double root = rootFinding.solve(12, 14);
        System.out.println("Bisection Method: root = " + root);

        rootFinding.setRootSolver(secantSolver);
        root = rootFinding.solve(12, 14);
        System.out.println("Newton-Raphson Method: root = " + root);

        rootFinding.setRootSolver(newtonRaphsonSolver);
        root = rootFinding.solve(12, 14);
        System.out.println("Secant Method: root = " + root);
    }
}
