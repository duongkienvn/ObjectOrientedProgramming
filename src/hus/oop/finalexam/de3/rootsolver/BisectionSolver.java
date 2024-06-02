package hus.oop.finalexam.de3.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double mid = 0;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2;
            double fMid = function.evaluate(mid);
            double fLower = function.evaluate(lower);

            if (Math.abs(fMid) < tolerance || (upper - lower) / 2 < tolerance) {
                return mid;
            }
            if (Math.signum(fMid) == Math.signum(fLower)) {
                lower = mid;
            } else {
                upper = mid;
            }
        }
        return mid;
    }
}
