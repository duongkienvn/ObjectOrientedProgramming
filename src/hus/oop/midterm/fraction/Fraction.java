package hus.oop.midterm.fraction;

public class Fraction extends Number implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction(Fraction fraction) {
        this.numerator = fraction.getNumerator();
        this.denominator = fraction.getDenominator();
        simplify();
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction another) {
//        return new Fraction(
//                numerator * another.getDenominator() + another.getNumerator() * denominator,
//                denominator * another.getDenominator()
//        );
        return new Fraction(
                numerator * another.getDenominator() + another.getNumerator() * denominator,
                denominator * another.getDenominator()
        );

    }

    public Fraction add(int value) {
//        return add(new Fraction(value));
        return add(new Fraction(value));
    }

    @Override
    public int compareTo(Fraction o) {
        return Double.compare(doubleValue(), o.doubleValue());
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    private void simplify() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public boolean equals(Fraction another) {
        if (another == null) {
            return false;
        }
        return numerator * another.getDenominator()
                == another.getNumerator() * denominator;
    }

    @Override
    public String toString() {
        return String.format("Fraction[%d/%d]", numerator, denominator);
    }
}
