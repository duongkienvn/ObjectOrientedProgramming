package hus.oop.midterm.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     *
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức trong khoảng [lower, upper]
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double x0 = lower;
        double x1 = upper;
        int iteration = 0;

        while (iteration < maxIterations) {
            double fx0 = polynomial.evaluate(x0);
            double fx1 = polynomial.evaluate(x1);
            if (Math.abs(fx1) < tolerance) {
                return x1;
            }

            double nextX = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            if (Math.abs(nextX - x1) < tolerance) {
                return nextX;
            }
            x0 = x1;
            x1 = nextX;
            iteration++;
        }

        return Double.NaN;
    }
}
