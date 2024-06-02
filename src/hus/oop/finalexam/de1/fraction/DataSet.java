package hus.oop.finalexam.de1.fraction;

import java.util.Arrays;
import java.util.Comparator;

public class DataSet {
    private static int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        this.data = new Fraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.data = data;
        this.length = data.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        /* TODO */
        if (!checkBoundaries(0, length)) {
            return false;
        }

        if (length >= data.length) {
            enlarge();
        }

        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = fraction;
        length++;
        return true;
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        /* TODO */
        Fraction simplifyData[] = new Fraction[length];
        for (int i = 0; i < length; i++) {
            simplifyData[i] = new Fraction(data[i]);
            simplifyData[i].simplify();
        }

        return new DataSet(simplifyData);
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        /* TODO */
        if (length >= data.length) {
            enlarge();
        }

        data[length] = fraction;
        length++;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        /* TODO */
        Fraction[] sorted = data.clone();
        Arrays.sort(sorted, Fraction::compareTo);
        return sorted;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        /* TODO */
        Fraction[] sorted = data.clone();
        Arrays.sort(sorted, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                int compare = Double.compare(o2.doubleValue(), o1.doubleValue());
                if (compare == 0) {
                    return o2.getDenominator() - o1.getDenominator();
                }
                return compare;
            }
        });
        return sorted;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        /* TODO */
        Fraction newData[] = new Fraction[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        /* TODO */
        return index >= 0 && index <= upperBound;
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(data[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        /* TODO */
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < fractions.length; i++) {
            sb.append(fractions[i]);
            if (i < fractions.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
