package hus.oop.finalexam.de1.fraction;

public class DecreasingOrderFraction implements FractionComparator {
    @Override
    public int compare(Fraction left, Fraction right) {
        double leftValue = left.doubleValue();
        double rightValue = right.doubleValue();
        int comparison = Double.compare(rightValue, leftValue);
        if (comparison == 0) {
            return right.getDenominator() - left.getDenominator();
        }
        return comparison;
    }
}
