package hus.oop.midterm.polynomial;

public interface RootSolver {
    /**
     * Tìm nghiệm của đa thức trong khoảng [lower, upper]
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     * dương
     */
    double solve(Polynomial polynomial, double lower, double upper);
}
