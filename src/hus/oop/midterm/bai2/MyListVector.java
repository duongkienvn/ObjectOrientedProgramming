package hus.oop.midterm.bai2;

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

    public MyListVector(double[] arr) {
        data = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            data.add(arr[i]);
        }
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] res = new double[size()];
        for (int i = 0; i < size(); i++) {
            res[i] = data.get(i);
        }

        return res;
    }

    @Override
    public void set(double value, int index) {
        data.set(index, value);
    }

    /**
     * Cộng các giá trị tọa độ với value.
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
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector add(MyListVector another) {
        if (this.size() != another.size()) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < size(); i++) {
            data.set(i, data.get(i) + another.data.get(i));
        }

        return this;
    }

    /**
     * Trừ các giá trị tọa độ của vector cho value.
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
     * @return
     */
//    public MyListVector minus() {
//        return null;
//    }

    /**
     * Trừ vector hiện tại với vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minus(MyListVector another) {
        if (this.size() != another.size()) {
            throw new IndexOutOfBoundsException();
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
     * @return vector hiện tại.
     */
    public double dot(MyListVector another) {
        double res = 0;
        for (int i = 0; i < size(); i++) {
            res += (this.data.get(i) + another.data.get(i));
        }
        return res;
    }

    /**
     * Các giá trị của vector được lấy mũ power.
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
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        double res = 0;
        for (int i = 0; i < size(); i++) {
            res += data.get(i) * data.get(i);
        }
        return Math.sqrt(res);
    }

    /**
     * Thêm một giá trị value vào tọa độ vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        data.add(size() ,value);
        return this;
    }

    /**
     * Thêm một giá trị vào tọa độ vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        data.add(index, value);
        return this;
    }

    /**
     * Xóa giá trị ở tọa độ thứ index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        data.remove(index);
        return this;
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các giá trị tọa độ
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có tọa độ được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        MyListVector newVector = new MyListVector();
        for (int i = 0; i < indices.length; i++) {
            newVector.insert(data.get(indices[i]));
        }
        return newVector;
    }
}
