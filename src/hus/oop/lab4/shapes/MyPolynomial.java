package hus.oop.lab4.shapes;

public class MyPolynomial {
    private double coeffs[];

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial another) {
        int maxDegree = Math.max(this.getDegree(), another.getDegree());
        double[] resultCoeffs = new double[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            double thisCoeff = (i <= this.getDegree()) ? this.coeffs[i] : 0;
            double anotherCoeff = (i <= another.getDegree()) ? another.coeffs[i] : 0;
            resultCoeffs[i] = thisCoeff + anotherCoeff;
        }
        return new MyPolynomial(resultCoeffs);
    }

    // Phương thức multiply để nhân đa thức hiện tại với một đa thức khác và trả về đa thức kết quả
    public MyPolynomial multiply(MyPolynomial another) {
        int resultDegree = this.getDegree() + another.getDegree();
        double[] resultCoeffs = new double[resultDegree + 1];
        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= another.getDegree(); j++) {
                resultCoeffs[i + j] += this.coeffs[i] * another.coeffs[j];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(coeffs[i]);
            } else {
                sb.append(coeffs[i] + "x^" + i + " + ");
            }
        }
        return String.valueOf(sb);
    }
}
