package hus.oop.finalexam.de1.integration;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        /* TODO */
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficient(int index) {
        /* TODO */
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return
     */
    @Override
    public double[] coefficients() {
        /* TODO */
        double coeffs[] = new double[coefficients.size()];

        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = coefficients.get(i);
        }

        return coeffs;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        /* TODO */
        coefficients.add(coefficient);
        return this;
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        /* TODO */
        coefficients.add(index, coefficient);
        return this;
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        /* TODO */
        coefficients.set(index, coefficient);
        return this;
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        /* TODO */
        return coefficients.size() - 1;
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;
        int degree = degree();
        for (int i = 0; i <= degree; i++) {
            result += coefficients.get(i) * Math.pow(x, i);
        }

        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        /* TODO */
        ListPolynomial derivative = new ListPolynomial();
        double derivativeCoeffs[] = differentiate();
        for (double coeff : derivativeCoeffs) {
            derivative.append(coeff);
        }

        return derivative;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeff = (i <= this.degree() ? this.coefficient(i) : 0) +
                    (i <= another.degree() ? another.coefficient(i) : 0);
            this.set(coeff, i);
        }
        return this;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        /* TODO */
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeff = (i < coefficients.size() ? coefficients.get(i) : 0) -
                    (i < another.coefficients.size() ? another.coefficients.get(i) : 0);
            this.set(coeff, i);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        /* TODO */
        int newDegree = this.degree() + another.degree();

        double resultCoeffs[] = new double[newDegree + 1];
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                resultCoeffs[i + j] += coefficients.get(i) * another.coefficients.get(j);
            }
        }

        coefficients.clear();
        for (int i = 0; i < resultCoeffs.length; i++) {
            this.append(resultCoeffs[i]);
        }

        return this;
    }
}
