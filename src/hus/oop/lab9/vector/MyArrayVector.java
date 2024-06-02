package hus.oop.lab9.vector;

import java.util.Arrays;
import java.util.Map;

public class MyArrayVector extends AbstractMyVector {
    private static final int DEFAULT_CAPACITY = 1;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
        /* TODO */
    }

    @Override
    public int size() {
        return size;
        /* TODO */
    }

    @Override
    public double coordinate(int index) {
        if (index > size) {
            throw new RuntimeException();
        }
        return data[index];
        /* TODO */
    }

    @Override
    public double[] coordinates() {
        double[] newData = new double[data.length];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        return newData;
        /* TODO */
    }

    @Override
    public void set(double value, int index) {
        if (index > size) {
            throw new RuntimeException();
        }
        data[index] = value;
        /* TODO */
    }

    /**
     * Cộng các giá trị tọa độ với value.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector add(double value) {
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
        /* TODO */
    }

    /**
     * Cộng vector khác vào vector hiện tại.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @param another
     * @return vector hiện tại.
     */
    public MyArrayVector add(MyArrayVector another) {
        if (size != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }
        for (int i = 0; i < size; i++) {
            data[i] = data[i] + another.data[i];
        }
        return this;
        /* TODO */
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minus(double value) {
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
        /* TODO */
    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return
     */
    /*public MyArrayVector minus() {
     *//* TODO *//*
    }*/

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector minus(MyArrayVector another) {
        if (size != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }
        for (int i = 0; i < size; i++) {
            data[i] = data[i] - another.data[i];
        }
        return this;
        /* TODO */
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector dot(MyArrayVector another) {
        if (size != another.size()) {
            throw new IllegalArgumentException("Hai vector không cùng số chiều.");
        }

        for (int i = 0; i < size; i++) {
            double temp = data[i] * another.data[i];
            data[i] = temp;
        }
        return this;
        /* TODO */
    }

    /**
     * Các giá trị của vector được lấy mũ power.
     *
     * @param power
     * @return vector hiện tại.
     */
    public MyArrayVector pow(double power) {
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
        /* TODO */
    }

    /**
     * Các giá trị tọa độ của vector được nhân với value.
     *
     * @return vector hiện tại.
     */
    public MyArrayVector scale(double value) {
        for (int i = 0; i < size; i++) {
            data[i] = data[i] * value;
        }
        return this;
        /* TODO */
    }

    /**
     * Lấy chuẩn của vector.
     *
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        double normVector = 0.0;
        for (int i = 0; i < size; i++) {
            double temp = data[i] * data[i];
            normVector += temp;
        }
        return Math.sqrt(normVector);
        /* TODO */
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value) {
        if (size == data.length) {
            MyArrayVector newData = enlarge();
            this.data = newData.data;
        }
        data[size++] = value;
        return this;
        /* TODO */
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * Nếu vector không còn đủ chỗ, mở rộng thêm kích thước vector.
     *
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector insert(double value, int index) {
        if (size == data.length) {
            MyArrayVector newData = enlarge();
            this.data = newData.data;
        }
        for (int i = size; i > index; i++) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return this;
        /* TODO */
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     *
     * @param index
     * @return vector hiện tại.
     */
    public MyArrayVector remove(int index) {
        if (index < 0 || index >= data.length) {
            throw new RuntimeException();
        }
        data[index] = 0;
        size--;
        return this;
        /* TODO */
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     *
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyArrayVector extract(int[] indices) {
        MyArrayVector childVector = new MyArrayVector();
        for (int i = 0; i < indices.length; i++) {
            childVector.set(data[indices[i] - 1], i);
        }
        return childVector;
        /* TODO */
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     *
     * @return vector hiện tại.
     */
    private MyArrayVector enlarge() {
        double[] newData = new double[2 * size];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        return this;
        /* TODO */
    }
}
