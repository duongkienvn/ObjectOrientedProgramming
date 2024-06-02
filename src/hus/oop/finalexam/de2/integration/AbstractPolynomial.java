package hus.oop.finalexam.de2.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder stringBuilder = new StringBuilder();

        int degree = degree();
        double coefficients[] = coefficients();

        stringBuilder.append("[");
        for (int i = degree; i >= 0; i--) {
            double coef = coefficients[i];

            if (i == 0) {
                stringBuilder.append(coef);
            } else {
                stringBuilder.append(coef + "x^" + i + " + ");
            }
        }
        stringBuilder.append("]");

        return String.valueOf(stringBuilder);
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        int degree = degree();
        double coefficients[] = coefficients();
        double derivativeCoefficients[] = new double[degree];

        for (int i = 1; i <= degree; i++) {
            derivativeCoefficients[i - 1] = coefficients[i] * i;
        }

        return derivativeCoefficients;
    }
}
