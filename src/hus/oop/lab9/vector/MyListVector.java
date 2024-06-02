package hus.oop.lab9.vector;

import java.util.ArrayList;
import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index không hợp lệ.");
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] coordinates = new double[size()];
        for (int i = 0; i < size(); i++) {
            coordinates[i] = data.get(i);
        }
        return coordinates;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index không hợp lệ.");
        }
        data.set(index, value);
    }

    /**
     * Cộng các giá trị tọa độ với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector add(double value) {
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector add(MyListVector another) {
        if (size() != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) + another.data.get(i));
        }
        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     *
     * @return vector hiện tại.
     */
    public MyListVector minus(double value) {
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyListVector minus(MyListVector another) {
        if (size() != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) - another.data.get(i));
        }
        return this;
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyListVector dot(MyListVector another) {
        if (size() != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) * another.data.get(i));
        }
        return this;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        for (int i = 0; i < size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    /**
     * Lấy chuẩn của vector.
     *
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        double normVector = 0.0;
        for (int i = 0; i < size(); i++) {
            double temp = data.get(i) * data.get(i);
            normVector += temp;
        }
        return Math.sqrt(normVector);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index không hợp lệ.");
        }
        data.add(index, value);
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index không hợp lệ.");
        }
        data.set(index, 0.0);
        return this;
    }

}
