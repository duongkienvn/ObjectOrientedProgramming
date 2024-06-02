package hus.oop.review.integration;

public class TrapezoidRule implements Integrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        this.maxIterations = maxIterations;
        this.precision = precision;
        /* TODO */
    }

    /**
     * Phương thức tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     *
     * @param poly
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(Polynomial poly, double lower, double upper) {
        int numOfSubIntervals = 1;
        double previousResult = integrate(poly, lower, upper, numOfSubIntervals);
        for (int i = 1; i <= maxIterations; i++) {
            numOfSubIntervals *= 2;
            double currentResult = integrate(poly, lower, upper, numOfSubIntervals);
            if (Math.abs(currentResult - previousResult) / 3 < precision) {
                return currentResult;
            }
            previousResult = currentResult;
        }
        return previousResult;
    }

    private double integrate(Polynomial poly, double lower, double upper, int numOfSubIntervals) {
        double intervalLength = (upper - lower) / numOfSubIntervals;
        double sum = 0.5 * (poly.evaluate(lower) + poly.evaluate(upper));

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * intervalLength;
            sum += poly.evaluate(x);
        }

        return sum * intervalLength;
    }
}
