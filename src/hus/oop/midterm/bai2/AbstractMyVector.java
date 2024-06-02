package hus.oop.midterm.bai2;

public abstract class AbstractMyVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        double[] temp = coordinates();
        int length = coordinates().length;
        String res = "";
        if (length == 1) {
            return "[" + temp[0] + "]";
        }
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                res += "[" + temp[i] + ", ";
            } else if (i == length - 1) {
                res += temp[i] + "]";
            } else {
                res += temp[i] + ", ";
            }

        }
        return res;
    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng số chiều và có tọa độ bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        if (coordinates().length != another.coordinates().length) {
            return false;
        }
        for (int i = 0; i < coordinates().length; i++) {
            if (coordinates()[i] != another.coordinates()[i]) {
                return false;
            }
        }
        return true;
    }
}
