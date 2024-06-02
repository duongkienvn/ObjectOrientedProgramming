package hus.oop.lab9.collections.polynomials;

import java.util.ArrayList;
import java.util.List;

public class ListPoly extends AbstractPoly {
    List<Double> coefficients;

    public ListPoly(double[] coeffs) {
        coefficients = new ArrayList<>();
        for (double coeff : coeffs) {
            coefficients.add(coeff);
        }
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public Poly derivative() {
        double derivedCoefficients[] = new double[coefficients.size() - 1];

        for (int i = 1; i < coefficients.size(); i++) {
            derivedCoefficients[i - 1] = coefficients.get(i) * i;
        }

        return new ListPoly(derivedCoefficients);
    }

    @Override
    public double coefficient(int degree) {
        if (degree > 0 && degree < coefficients.size()) {
            return coefficients.get(degree);
        } else {
            return 0;
        }
    }

    @Override
    public double[] coefficients() {
        double[] coeffsArray = new double[coefficients.size()];
        for (int i = 0; i < coeffsArray.length; i++) {
            coeffsArray[i] = coefficients.get(i);
        }
        return coeffsArray;
    }
}
