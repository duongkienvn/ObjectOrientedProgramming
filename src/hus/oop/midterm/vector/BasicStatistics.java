package hus.oop.midterm.vector;

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
        System.out.println("testArrayVector: ");
        testArrayVector();
        System.out.println("\ntestListVector");
        testListVector();
        System.out.println("\ndoSimpleTest");
        doSimpleStatic();
    }

    public static void testArrayVector() {
        /* TODO */
        MyArrayVector myArrayVector = new MyArrayVector();
        myArrayVector.insert(1);
        myArrayVector.insert(2);
        myArrayVector.insert(3);

        System.out.println("myArrayVector: " + myArrayVector);

        myArrayVector.insert(4, 2);
        System.out.println("\naftering inserting: " + myArrayVector);

        myArrayVector.remove(2);
        System.out.println("\naftering remove at index = 2: " + myArrayVector);

        myArrayVector.set(5, 2);
        System.out.println("\naftering modification: " + myArrayVector);

        MyArrayVector anotherVector = new MyArrayVector();
        anotherVector.insert(8);
        anotherVector.insert(9);
        anotherVector.insert(10);

        myArrayVector.add(anotherVector);
        System.out.println("\naftering plus: " + myArrayVector);

        myArrayVector.minus(anotherVector);
        System.out.println("\naftering minus: " + myArrayVector);

        double dotProduct = myArrayVector.dot(anotherVector);
        System.out.println("\ntich vo huong: " + dotProduct);

        myArrayVector.scale(5);
        System.out.println("\naftering scale: " + myArrayVector);

        myArrayVector.add(4);
        System.out.println("\naftering add 4: " + myArrayVector);

        myArrayVector.minus(4);
        System.out.println("\naftering minus 4: " + myArrayVector);

        int indices[] = {1, 2};
        myArrayVector.extract(indices);
        System.out.println("\naftering extract: " + myArrayVector);
    }

    public static void testListVector() {
        /* TODO */
        MyListVector myListVector = new MyListVector();
        myListVector.insert(1);
        myListVector.insert(2);
        myListVector.insert(3);

        System.out.println("myListVector: " + myListVector);

        myListVector.insert(4, 2);
        System.out.println("\naftering inserting: " + myListVector);

        myListVector.remove(2);
        System.out.println("\naftering remove at index = 2: " + myListVector);

        myListVector.set(5, 2);
        System.out.println("\naftering modification: " + myListVector);

        MyListVector anotherVector = new MyListVector();
        anotherVector.insert(8);
        anotherVector.insert(9);
        anotherVector.insert(10);

        myListVector.add(anotherVector);
        System.out.println("\naftering plus: " + myListVector);

        myListVector.minus(anotherVector);
        System.out.println("\naftering minus: " + myListVector);

        double dotProduct = myListVector.dot(anotherVector);
        System.out.println("\ntich vo huong: " + dotProduct);

        myListVector.scale(5);
        System.out.println("\naftering scale: " + myListVector);

        myListVector.add(4);
        System.out.println("\naftering add 4: " + myListVector);

        myListVector.minus(4);
        System.out.println("\naftering minus 4: " + myListVector);

        int indices[] = {1, 2};
        myListVector.extract(indices);
        System.out.println("\naftering extract: " + myListVector);
    }

    public void creatVector() {
        vectors = new MyVector[10];
        vectors[0] = new MyListVector(new double[]{1, 2, 3});
        vectors[1] = new MyListVector(new double[]{1, 3, 2});
        for (int i = 2; i < vectors.length; i++) {
            vectors[i] = new MyListVector();
            for (int j = 0; j < 3; j++) {
                MyListVector myListVector = (MyListVector) vectors[i];
                myListVector.insert(Math.random() * 10);
            }
        }
    }

    public static void doSimpleStatic() {
        /* TODO */
        BasicStatistics basicStatistics = new BasicStatistics();
        basicStatistics.creatVector();

        double maxNorm = basicStatistics.normMax();
        double minNorm = basicStatistics.normMin();
        System.out.println(minNorm);
        System.out.println(maxNorm);

        MyVector sortedByIncreasingNorm[] = basicStatistics.sortNorm(true);
        System.out.println("xep tang dan theo norm");
        for (MyVector vector : sortedByIncreasingNorm) {
            System.out.println(vector.toString());
        }

        MyVector sortedByDecreasingNorm[] = basicStatistics.sortNorm(false);
        System.out.println("\nxep giam dan theo norm");
        for (MyVector vector : sortedByDecreasingNorm) {
            System.out.println(vector.toString());
        }

        MyVector filter[] = basicStatistics.filter(1, 20);
        System.out.println("\nvector co norm tu 1 den 20: ");
        for (MyVector vector : filter) {
            System.out.println(vector.toString());
        }

        double ranks[] = basicStatistics.rank1();
        System.out.println("\nrank của các vector theo thứ tự trong mảng vectors: ");
        for (double rank : ranks) {
            System.out.print(rank + " ");
        }
    }

    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     *
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        /* TODO */
        double maxNorm = Double.MIN_VALUE;
        for (MyVector vector : vectors) {
            double norm = vector.norm();
            maxNorm = Math.max(maxNorm, norm);
        }
        return maxNorm;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     *
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        /* TODO */
        double minNorm = Double.MAX_VALUE;
        for (MyVector vector : vectors) {
            double norm = vector.norm();
            minNorm = Math.min(minNorm, norm);
        }
        return minNorm;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     *
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        /* TODO */
        MyVector sortedNorm[] = vectors.clone();
        Arrays.sort(sortedNorm, (a, b) -> {
            if (order) {
                return Double.compare(a.norm(), b.norm());
            } else {
                return Double.compare(b.norm(), a.norm());
            }
        });
        return sortedNorm;
    }

    /**
     * Lọc ra mảng các vector có chuẩn năm trong đoạn [from, to].
     *
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(int from, int to) {
        /* TODO */
        List<MyVector> filteredVectors = new ArrayList<>();
        for (MyVector vector : vectors) {
            if (vector.norm() >= from && vector.norm() <= to) {
                filteredVectors.add(vector);
            }
        }
        return filteredVectors.toArray(new MyVector[0]);
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     * - tập [3 1 4] có rank [2.0 1.0 3.0]
     * - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     * được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ sổ bắt
     * đầu là 1)
     *
     * @return
     */
    public double[] rank() {
        /* TODO */
        MyVector increasingByNorm[] = sortNorm(true);

        Map<MyVector, Integer> frequency = new HashMap<>();
        for (MyVector vector : increasingByNorm) {
            frequency.put(vector, frequency.getOrDefault(vector, 0) + 1);
        }

        Map<MyVector, Double> index = new HashMap<>();
        for (int i = 0; i < increasingByNorm.length; i++) {
            if (index.containsKey(increasingByNorm[i])) {
                continue;
            } else {
                double sumIndex = 0;
                for (int j = 0; j < frequency.get(increasingByNorm[i]); j++) {
                    sumIndex += i + 2;
                }
                index.put(increasingByNorm[i], sumIndex / frequency.get(increasingByNorm[i]));
            }
        }

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < increasingByNorm.length; i++) {
            if (index.containsKey(vectors[i])) {
                continue;
            } else {
                list.add(index.get(vectors[i]));
            }
        }

        double result[] = new double[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public double[] rank1() {
        int n = vectors.length;
        double[] rank = new double[n];

        // Tạo một mảng phụ để lưu giữ thông tin về chuẩn và chỉ số ban đầu của mỗi vector
        VectorInfo[] vectorInfos = new VectorInfo[n];
        for (int i = 0; i < n; i++) {
            vectorInfos[i] = new VectorInfo(i, vectors[i].norm());
        }

        // Sắp xếp mảng vectorInfos theo thứ tự tăng dần của chuẩn
        Arrays.sort(vectorInfos, Comparator.comparingDouble(v -> v.norm));

        // Tính rank cho các vector
        double sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1;
            count++;
            if (i == n - 1 || vectorInfos[i].norm != vectorInfos[i + 1].norm) {
                for (int j = i - count + 1; j <= i; j++) {
                    rank[vectorInfos[j].index] = sum / count;
                }
                sum = 0;
                count = 0;
            }
        }

        return rank;
    }

    private static class VectorInfo {
        int index;
        double norm;

        VectorInfo(int index, double norm) {
            this.index = index;
            this.norm = norm;
        }

        double norm() {
            return norm;
        }
    }
}
