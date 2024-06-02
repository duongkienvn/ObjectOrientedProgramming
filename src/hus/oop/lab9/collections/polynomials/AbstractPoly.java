package hus.oop.lab9.collections.polynomials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
public abstract class AbstractPoly implements Poly{
    double[] derive() {
        int degree = degree();
        double coefficients[] = new double[degree];

        for (int i = 1; i <= degree; i++) {
            coefficients[i - 1] = coefficient(i) * i;
        }

        return coefficients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractPoly abstractPoly = (AbstractPoly) o;
        return Arrays.equals(this.coefficients(), abstractPoly.coefficients());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coefficients());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        double coefficients[] = coefficients();
        int degree = degree();

        for (int i = degree; i >= 0; i--) {
            double coef = coefficients[i];

            if (i == 0) {
                stringBuilder.append(coef);
            } else {
                stringBuilder.append(coef + "x^" + i + " + ");
            }
        }

        return String.valueOf(stringBuilder);
    }
}
