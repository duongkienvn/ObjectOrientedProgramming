package hus.oop.midterm.taylor;

import java.math.BigInteger;

public class MyMath {
    static final double EPS = 1e-15;

    public static double cos(double x) {
        double result = 0;
        double term = 1;
        int n = 0;
        while (Math.abs(term) > 1e-15) {
            result += term;
            n += 2;
            term *= -x * x / (n * (n - 1));
        }
        return result;
    }

    public static double sin(double x) {
        double result = 0;
        double term = x;
        int n = 1;
        while (Math.abs(term) > 1e-15) {
            result += term;
            n += 2;
            term *= -x * x / (n * (n - 1));
        }
        return result;
    }

    public static String decimalTo(String number, int outRadix) {
        String outpStr = "";
        BigInteger decimal = new BigInteger(number);
        BigInteger radix = BigInteger.valueOf(outRadix);
        while (!decimal.equals(BigInteger.ZERO)) {
            BigInteger[] divMod = decimal.divideAndRemainder(radix);
            BigInteger surplus = divMod[1];
            decimal = divMod[0];
            outpStr = surplus + outpStr;
        }
        return outpStr;
    }

    public static double exp(double x) {
        double result = 1;
        double term = 1;
        int n = 1;
        while (Math.abs(term) > 1e-15) {
            result += term;
            n++;
            term *= x / n;
        }
        return result;
    }

    public static String toDecimal(String number, int inRadix) {
        BigInteger outNum = BigInteger.ZERO;
        BigInteger radix = BigInteger.valueOf(inRadix);
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            int value;
            if (Character.isDigit(digit)) {
                value = digit - '0'; // Nếu là chữ số, chuyển đổi thành giá trị số
            } else {
                value = digit - 'A' + 10; // Nếu là chữ cái, chuyển đổi thành giá trị số tương ứng với A=10, B=11, ..., Z=35
            }
            outNum = outNum.multiply(radix).add(BigInteger.valueOf(value));
        }
        return outNum.toString();
    }

    public static String toRadix(String number, int inRadix, int outRadix) {
        String outNum = "";
        String decimal = toDecimal(number, inRadix);
        outNum = decimalTo(decimal, outRadix);
        return outNum;
    }

    public static void main(String[] args) {
        // Create an instance of MyMath class
        MyMath myMath = new MyMath();

        // Tính giá trị của biểu thức: e^2.2 * cos(3.3)
        double result = myMath.exp(2.2) * myMath.cos(3.3);
        System.out.println("Result of e^2.2 * cos(3.3): " + result);

        // Chuyển số nguyên “123456789123456789” từ hệ cơ số 13 sang hệ cơ số 8
        String numberInBase13 = "123456789123456789";
        String numberInBase8 = myMath.toRadix(numberInBase13, 13, 8);
        System.out.println("Number in base 8: " + numberInBase8);

        // Tính giá trị của biểu thức: e^2.2 * sin(3.3)
        double resultSin = myMath.exp(2.2) * myMath.sin(3.3);
        System.out.println("Result of e^2.2 * sin(3.3): " + resultSin);
    }
}
