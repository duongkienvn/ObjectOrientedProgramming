package hus.oop.review.integration;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 2;
    private double[] coefficents;
    private int size;

    public ArrayPolynomial(double[] data) {
        this.coefficents = data;
        size = data.length;
    }

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
        /* TODO */
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     *
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficient(int index) {
        return coefficents[index];
        /* TODO */
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     *
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        double[] newCoeff = new double[size];
        System.arraycopy(coefficents, 0, newCoeff, 0, size);
        return newCoeff;
        /* TODO */
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     *
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial append(double coefficient) {
        if (size == this.coefficents.length) {
            enlarge();
        }
        this.coefficents[size++] = coefficient;
        return this;
        /* TODO */
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial insert(double coefficient, int index) {
        if (size == this.coefficents.length) {
            enlarge();
        }
        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        this.coefficents[index] = coefficient;
        size++;
        return this;
        /* TODO */
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     *
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial set(double coefficient, int index) {
        this.coefficents[index] = coefficient;
        return this;
        /* TODO */
    }

    /**
     * Lấy bậc của đa thức.
     *
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        return size - 1;
        /* TODO */
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     *
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += this.coefficents[i] * Math.pow(x, i);
        }
        return result;
        /* TODO */
    }

    /**
     * Lấy đạo hàm của đa thức.
     *
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        double[] differ = this.differentiate();
        return new ArrayPolynomial(differ);
        /* TODO */
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        int maxSize = Math.max(this.size, another.size);
        while (this.coefficents.length < maxSize) {
            enlarge();
        }
        for (int i = 0; i < maxSize; i++) {
            double coeffi1 = (i < this.size) ? this.coefficents[i] : 0;
            double coeffi2 = (i < another.size) ? another.coefficents[i] : 0;
            this.set(coeffi1 + coeffi2, i);
        }
        return this;
        /* TODO */
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial minus(ArrayPolynomial another) {
        int maxSize = Math.max(this.size, another.size);
        while (this.coefficents.length < maxSize) {
            enlarge();
        }
        for (int i = 0; i < maxSize; i++) {
            double coeffi1 = (i < this.size) ? this.coefficents[i] : 0;
            double coeffi2 = (i < another.size) ? another.coefficents[i] : 0;
            set(coeffi1 - coeffi2, i);
        }
        return this;
        /* TODO */
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     *
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        int newSize = size + another.size - 1;
        double[] tempCoefficients = Arrays.copyOf(coefficents, size);
        while (this.coefficents.length < newSize){
            enlarge();
        }
        for (int i = 0; i < newSize; i++) {
            double sum = 0.0;
            for (int j = 0; j <= i; j++) {
                if (j < size && (i - j) < another.size) {
                    sum += tempCoefficients[j] * another.coefficents[i - j];
                }
            }
            set(sum, i);
        }
        size = newSize;
        return this;
        /* TODO */
    }

    /**
     * Thêm kích thước để lưu đa thức khi cần thiết.
     */
    private void enlarge() {
        int newCapacity = coefficents.length * 2;
        double[] newCoefficients = new double[newCapacity];
        System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        coefficents = newCoefficients;
        /* TODO */
    }
}
