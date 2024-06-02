package hus.oop.review.integration;

public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        StringBuilder polynomial = new StringBuilder();
        int degree = degree();
        for (int i = degree; i >= 0; i--) {
            double coeff = coefficient(i);
            if (coeff != 0) {
                if (polynomial.length() > 0 && coeff > 0) {
                    polynomial.append(" + ");
                } else {
                    polynomial.append(" ");
                }
                if (i == 0) {
                    polynomial.append(coeff);
                } else {
                    if (coeff != 1) {
                        polynomial.append(coeff);
                    }
                    polynomial.append("x");
                    if (i > 1) {
                        polynomial.append("^").append(i);
                    }
                }
            }
        }
        return polynomial.toString();
        /* TODO */
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        double[] coeffi = coefficients();
        double[] differ = new double[coeffi.length - 1];
        for (int i = 0; i < differ.length; i++) {
            differ[i] = coeffi[i + 1] * (i + 1);
        }
        return differ;
        /* TODO */
    }
}
