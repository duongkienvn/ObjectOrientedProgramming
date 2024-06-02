package hus.oop.review.integration;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial(List<Double> coefficients) {
        this.coefficients = coefficients;
    }

    public ListPolynomial() {
        coefficients = new LinkedList<>();
        /* TODO */
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     *
     * @return
     */
    @Override
    public double coefficient(int index) {
        return coefficients.get(index);
        /* TODO */
    }

    /**
     * Lấy các hệ số của đa thức.
     *
     * @return
     */
    @Override
    public double[] coefficients() {
        double[] coeffi = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            coeffi[i] = coefficient(i);
        }
        return coeffi;
        /* TODO */
    }

    /**
     * Thêm phần tử có hệ số coefficient vào cuối đa thức hiện tại.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
        /* TODO */
    }

    /**
     * Thêm phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial insert(double coefficient, int index) {
        coefficients.add(index, coefficient);
        return this;
        /* TODO */
    }

    /**
     * Sửa hệ số của phần tử index là coefficient.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ListPolynomial set(double coefficient, int index) {
        coefficients.set(index, coefficient);
        return this;
        /* TODO */
    }

    /**
     * Lấy ra bậc của đa thức.
     *
     * @return
     */
    @Override
    public int degree() {
        return coefficients.size() - 1;
        /* TODO */
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return
     */
    @Override
    public double evaluate(double x) {
        double ans = 0.0;
        for (int i = 0; i < coefficients.size(); i++) {
            ans += Math.pow(x, i) * coefficient(i);
        }
        return ans;
        /* TODO */
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        ListPolynomial listPolynomial = new ListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            listPolynomial.append(coefficients.get(i) * i);
        }
        return listPolynomial;
        /* TODO */
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
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
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        int maxSize = Math.max(this.coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            double coeff1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0;
            double coeff2 = (i < another.coefficients.size()) ? another.coefficients.get(i) : 0;
            this.coefficients.set(i, coeff1 - coeff2);
        }
        return this;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                int index = i + j;
                double value = this.coefficients.get(i) * another.coefficients.get(j);
                if (index < result.coefficients.size()) {
                    result.coefficients.set(index, result.coefficients.get(index) + value);
                } else {
                    result.coefficients.add(value);
                }
            }
        }
        while (this.coefficients.size() < result.coefficients.size()) {
            this.coefficients.add(0.0);
        }
        for (int i = 0; i < result.coefficients.size(); i++) {
            this.coefficients.set(i, result.coefficients.get(i));
        }
        return this;
    }
}
