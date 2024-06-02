package hus.oop.midterm.polynomial;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     *
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.maxIterations = maxIterations;
        this.tolerance = tolerance;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp chia đôi (Bisection)
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        /* TODO */
        double fLower = polynomial.evaluate(lower);
        double fUpper = polynomial.evaluate(upper);
        if (fUpper * fLower > 0) {
            return Double.NaN;
        }

        int iteration = 0;
        while (iteration < maxIterations) {
            double mid = (lower + upper) / 2;
            double fMid = polynomial.evaluate(mid);
            if (Math.abs(fMid) < tolerance || (upper - lower) / 2 < tolerance) {
                return mid;
            }
            if (fMid * fLower < 0) {
                upper = mid;
                fUpper = fMid;
            } else {
                lower = mid;
                fLower = fMid;
            }
            iteration++;
        }

        return Double.NaN;
    }
}
