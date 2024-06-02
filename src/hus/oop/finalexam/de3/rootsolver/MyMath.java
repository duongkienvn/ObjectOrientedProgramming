package hus.oop.finalexam.de3.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double term = x;
        double sum = 0;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            sum += term;
            term *= -1 * x * x / (2 * n) / (2 * n + 1);
            n++;
        }
        return sum;
    }

    public static double cos(double x) {
        /* TODO */
        double term = 1;
        double sum = 0;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            sum += term;
            term *= -1 * x * x / (2 * n - 1) / (2 * n);
            n++;
        }
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double term = 1;
        double sum = 0;
        int n = 1;
        while (Math.abs(term) > 1e-10) {
            sum += term;
            term *= x / n;
            n++;
        }
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        double result = 0;
        double term = (x - 1) / x;
        int sign = 1;
        int i = 1;

        while (Math.abs(term) > 1e-10) {
            result += sign * term;
            term *= (x - 1) / x;
            sign *= -1;
            i++;
        }

        return result;
    }
}
