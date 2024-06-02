package hus.oop.midterm.bai2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BasicStatistics {
    private MyVector[] vectors;

    public static void main(String[] args) {
        /*
         TODO

         Thực hiện các yêu cầu sau.

         I. Test chức năng vector
           - Viết các hàm testArrayVector để test các chứ năng của array vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...
           - Viết các hàm testListVector để test các chứ năng của list vector, như thêm vào tọa độ, xóa bớt số trục tọa độ,
             sửa giá trị tọa độ, cộng các vector, nhân vector với giá trị vô hướng, nhân vô hướng 2 vector, ...

         II. Thực hiện thống kê đơn giản với các vector
           - Tạo ra ít nhất 10 vector và cho vào mảng vectors để quản lý. Trong đó có ít nhất 2 nhóm các vector
             có chuẩn bằng nhau.
           - Tìm và in ra thông tin chuẩn nhó nhất, chuẩn lớn nhất của các vector.
           - In ra các vector có chuẩn sắp xếp theo thứ tự tăng dần, giản dần.
           - In ra các vector có chuẩn nằm trong một đoạn [a, b] cho trước.
           - In ra rank của các vector theo thứ tự trong mảng vectors.

         III. Lưu các kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_Vector>.txt
              (ví dụ NguyenVanA_123456_Vector.txt) và nộp cùng source code.
         */
        try {
            PrintWriter writer = new PrintWriter("C:\\Users\\EGlaciers\\PracticeJava\\src\\hus\\oop\\de_gk_2023_de2\\bai2\\TranXuanViet_23001955", StandardCharsets.UTF_16);

            writer.println("I.Test chức năng vector");
            writer.println();
            writer.println("Test Array Vector");
            //testArrayVector(writer);

            writer.println();
            writer.println("Test List Vector");
            //testListVector(writer);
            writer.println("----------------------------------");
            writer.println();
            writer.println("II. Thống kê với vector");

            doSimpleStatic(writer);

            writer.println("----------------------------------");
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void testArrayVector(PrintWriter writer) {
        MyArrayVector vector = new MyArrayVector();
        vector.insert(1);
        vector.insert(3);
        vector.insert(5);
        writer.print("Vector: ");
        writer.println(vector);
        writer.println(vector.coordinate(2));
        writer.println("Set 2th element to 2.0: ");
        vector.set(2.0, 2);
        writer.println(vector);
        writer.println("Add all element to 5.0: ");
        writer.println(vector.add(5));

        writer.println("Subtract all element to 5.0: ");
        writer.println(vector.minus(5));

        writer.println("Tích vô hướng của 2 vector: ");
        MyArrayVector vector2 = new MyArrayVector();
        vector2.insert(2);
        vector2.insert(6);
        vector2.insert(1);
        writer.println(vector.dot(vector2));

        writer.println("Lấy mũ 2 các phần tử trong vector1: ");
        writer.println(vector.pow(2));

        writer.println("Scale the vector to 3.0");
        writer.println(vector.scale(3));

        writer.println("Norm of vector: ");
        writer.println(vector.norm());

        writer.println("Remove 2th element of the vector: ");
        writer.println(vector.remove(1));

        writer.println("Trích xuất phần tử theo chỉ số: ");
        MyArrayVector vector3 = new MyArrayVector();
        vector3.insert(3);
        vector3.insert(5);
        vector3.insert(1);
        vector3.insert(8);
        vector3.insert(7);
        int[] indices = {2, 0};
        writer.println(vector3.extract(indices));
    }


    public static void testListVector(PrintWriter writer) {
        MyListVector vector = new MyListVector();
        vector.insert(1);
        vector.insert(3);
        vector.insert(5);
        writer.print("Vector: ");
        writer.println(vector);
        writer.println(vector.coordinate(2));
        writer.println("Set 2th element to 2.0: ");
        vector.set(2.0, 2);
        writer.println(vector);
        writer.println("Add all element to 5.0: ");
        writer.println(vector.add(5));

        writer.println("Subtract all element to 5.0: ");
        writer.println(vector.minus(5));

        writer.println("Tích vô hướng của 2 vector: ");
        MyListVector vector2 = new MyListVector();
        vector2.insert(2);
        vector2.insert(6);
        vector2.insert(1);
        writer.println(vector.dot(vector2));

        writer.println("Lấy mũ 2 các phần tử trong vector1: ");
        writer.println(vector.pow(2));

        writer.println("Scale the vector to 3.0");
        writer.println(vector.scale(3));

        writer.println("Norm of vector: ");
        writer.println(vector.norm());

        writer.println("Remove 2th element of the vector: ");
        writer.println(vector.remove(1));

        writer.println("Trích xuất phần tử theo chỉ số: ");
        MyListVector vector3 = new MyListVector();
        vector3.insert(3);
        vector3.insert(5);
        vector3.insert(1);
        vector3.insert(8);
        vector3.insert(7);
        int[] indices = {2, 0};
        writer.println(vector3.extract(indices));
    }

    public static void doSimpleStatic(PrintWriter writer) {
        BasicStatistics statistics = new BasicStatistics();
        statistics.createVectors();

        writer.println();
        writer.println("In ra maxNorm: " + statistics.normMax());
        writer.println("In ra minNorm: " + statistics.normMin());
        MyVector[] sortedVectors = statistics.sortNorm(true);
        printVector(sortedVectors, writer);

        writer.println("Lọc ra vector có norm trong khoảng [a, b]: ");
        MyVector[] filters = statistics.filter(3, 10);
        printVector(filters, writer);

        writer.println("Rank theo chuẩn của mảng các vector: ");
        statistics.rank();
    }

    public static void printVector(MyVector[] vectors, PrintWriter writer) {
        for (int i = 0; i < vectors.length; i++) {
            writer.println(vectors[i] + " " + vectors[i].norm());
        }
    }

    public void createVectors() {
        vectors = new MyVector[10];
        vectors[0] = new MyListVector(new double[] {1, 2, 3});
        vectors[1] = new MyListVector(new double[] {1, 3, 2});
        for(int i = 2; i < 10; i++) {
            int ele1 = (int) (Math.random() * 10 + 1);
            int ele2 = (int) (Math.random() * 10 + 1);
            int ele3 = (int) (Math.random() * 10 + 1);
            vectors[i] = new MyListVector(new double[] {ele1, ele2, ele3});
        }
    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        double maxNorm = Double.MIN_VALUE;
        for (int i = 0; i < vectors.length; i++) {
            if (vectors[i].norm() > maxNorm) {
                maxNorm = vectors[i].norm();
            }
        }
        return maxNorm;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        double minNorm = Double.MAX_VALUE;
        for (int i = 0; i < vectors.length; i++) {
            if (vectors[i].norm() < minNorm) {
                minNorm = vectors[i].norm();
            }
        }
        return minNorm;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        MyVector[] copyArr = vectors;
        SortNormComparator comparator = new SortNormComparator();
        for (int i = 0; i < copyArr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < copyArr.length - i - 1; j++) {
                if (order ? comparator.compare(copyArr[j], copyArr[j + 1]) > 0 : comparator.compare(copyArr[j], copyArr[j + 1]) < 0) {
                    MyVector tmp = copyArr[j];
                    copyArr[j] = copyArr[j + 1];
                    copyArr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return copyArr;
    }

    /**
     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(int from, int to) {
        MyVector[] filterArr = new MyVector[10];
        int index = 0;
        for (int i = 0; i < vectors.length; i++) {
            if (vectors[i].norm() > (from * 1.0) && vectors[i].norm() < (to * 1.0)) {
                filterArr[index++] = vectors[i];
            }
        }
        filterArr = Arrays.copyOf(filterArr, index);
        return filterArr;
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     *   - tập [3 1 4] có rank [2.0 1.0 3.0]
     *   - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     *     được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
     *     đầu là 1)
     * @return
     */

    public double[] rank() {
        double[] normVectors = new double[vectors.length];
        double[] copyOfVectors = normVectors;
        double[] res = new double[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            normVectors[i] = vectors[i].norm();
        }

        for (int i = 0; i < normVectors.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < normVectors.length - i - 1; j++) {
                if (normVectors[j] > normVectors[j + 1]) {
                    double tmp = normVectors[j];
                    normVectors[j] = normVectors[j + 1];
                    normVectors[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        Map<Double, Integer> frequency = new HashMap<>();
        for (int i = 0; i < normVectors.length; i++) {
            if (frequency.containsKey(copyOfVectors[i])) {
                frequency.put(copyOfVectors[i], frequency.get(copyOfVectors[i]) + 1);
            } else {
                frequency.put(copyOfVectors[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> x : frequency.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }

        Set<Double> keySet = frequency.keySet();

        for (Double x : keySet) {
            System.out.print(x + " ");
        }

        return null;
    }

}
