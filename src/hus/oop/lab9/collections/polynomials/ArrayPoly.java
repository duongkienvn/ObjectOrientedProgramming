package hus.oop.lab9.collections.polynomials;

public class ArrayPoly extends AbstractPoly {
    private final double[] coefficients;

    public ArrayPoly(double[] coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public int degree() {
        return coefficients.length - 1;
    }

    @Override
    public Poly derivative() {
        double[] derivedCoefficients = new double[coefficients.length - 1];

        for (int i = 1; i < coefficients.length; i++) {
            derivedCoefficients[i - 1] = coefficients[i] * i;
        }

        return new ArrayPoly(derivedCoefficients);
    }

    @Override
    public double coefficient(int degree) {
        if (degree > 0 && degree < coefficients.length) {
            return coefficients[degree];
        } else {
            return 0;
        }
    }

    @Override
    public double[] coefficients() {
        return coefficients.clone();
    }
}
