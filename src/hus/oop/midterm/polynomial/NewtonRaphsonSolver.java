package hus.oop.midterm.polynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }

    /**
     * Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double x0 = (lower + upper) / 2;
        int iteration = 0;
        while (iteration < maxIterations) {
            double fx0 = polynomial.evaluate(x0);
            double dfx0 = polynomial.derivative().evaluate(x0);
            if (Math.abs(fx0) < tolerance) {
                return x0;
            }

            double nextX = x0 - fx0 / dfx0;
            if (Math.abs(nextX - x0) < tolerance) {
                return nextX;
            }
            x0 = nextX;
            iteration++;
        }

        return Double.NaN;
    }
}
