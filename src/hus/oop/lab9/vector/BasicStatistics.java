package hus.oop.lab9.vector;

public class BasicStatistics {
    private MyVector[] vectors;

    public static void main(String[] args) {
        testArrayVector();
        testListVector();
        doSimpleStatic();
    }


    public static void testArrayVector() {
        MyArrayVector vector1 = new MyArrayVector();
        vector1.insert(1);
        vector1.insert(2);
        vector1.insert(3);

        MyArrayVector vector2 = new MyArrayVector();
        vector2.insert(4);
        vector2.insert(5);
        vector2.insert(6);

        // Thêm các vector vào mảng vectors
        BasicStatistics basicStatistics = new BasicStatistics();
        basicStatistics.vectors = new MyVector[]{vector1, vector2};

        System.out.println("In vector trong array: ");
        for (MyVector vector : basicStatistics.vectors) {
            System.out.println(vector.toString());
        }

        // Hiển thị thông tin chuẩn của các vector
        for (MyVector vector : basicStatistics.vectors) {
            System.out.println("Norm: " + vector.norm());
        }
    }

    public static void testListVector() {
        MyListVector vector1 = new MyListVector();
        vector1.insert(1);
        vector1.insert(2);
        vector1.insert(3);

        MyListVector vector2 = new MyListVector();
        vector2.insert(4);
        vector2.insert(5);
        vector2.insert(6);

        // Thêm các vector vào mảng vectors
        BasicStatistics basicStatistics = new BasicStatistics();
        basicStatistics.vectors = new MyVector[]{vector1, vector2};

        System.out.println("In vector trong list: ");
        for (MyVector vector : basicStatistics.vectors) {
            System.out.println(vector.toString());
        }

        // Hiển thị thông tin chuẩn của các vector
        for (MyVector vector : basicStatistics.vectors) {
            System.out.println("Norm: " + vector.norm());
        }
    }

    public static void doSimpleStatic() {
        // Tạo danh sách vectors và thêm các vector vào danh sách này
        MyArrayVector vector1 = new MyArrayVector();
        vector1.insert(1);
        vector1.insert(6);
        vector1.insert(-1);

        MyArrayVector vector2 = new MyArrayVector();
        vector2.insert(1);
        vector2.insert(6);
        vector2.insert(-1);

        MyArrayVector vector3 = new MyArrayVector();
        vector3.insert(-6);
        vector3.insert(3);
        vector3.insert(11);

        MyArrayVector vector4 = new MyArrayVector();
        vector4.insert(13);
        vector4.insert(-22);
        vector4.insert(-56);

        // Thêm các vector vào mảng vectors
        BasicStatistics basicStatistics = new BasicStatistics();
        basicStatistics.vectors = new MyVector[]{vector1, vector2, vector3, vector4};

        // Hiển thị thông tin
        System.out.println("Norm Max: " + basicStatistics.normMax());
        System.out.println("Norm Min: " + basicStatistics.normMin());

        System.out.println("Vectors sorted by norm (ascending): ");
        MyVector[] sortedAsc = basicStatistics.sortNorm(true);
        for (MyVector vector : sortedAsc) {
            System.out.println("Norm: " + vector.norm());
        }

        System.out.println("Vectors sorted by norm (descending): ");
        MyVector[] sortedDesc = basicStatistics.sortNorm(false);
        for (MyVector vector : sortedDesc) {
            System.out.println("Norm: " + vector.norm());
        }

        System.out.println("Vectors with norm in range [3, 9]: ");
        MyVector[] filteredVectors = basicStatistics.filter(3, 9);
        for (MyVector vector : filteredVectors) {
            System.out.println("Norm: " + vector.norm());
        }

        System.out.println("Rank of vectors: ");
        double[] ranks = basicStatistics.rank();
        for (int i = 0; i < ranks.length; i++) {
            System.out.println("Rank of vector " + (i + 1) + ": " + ranks[i]);
        }
    }


    /**
     * Lấy giá trị chuẩn lớn nhất trong các vector.
     *
     * @return chuẩn lớn nhất.
     */
    public double normMax() {
        double max = vectors[0].norm();
        for (int i = 1; i < vectors.length; i++) {
            max = Math.max(max, vectors[i].norm());
        }
        return max;
    }

    /**
     * Lấy giá trị chuẩn nhỏ nhất trong các vector.
     *
     * @return chuẩn nhỏ nhất.
     */
    public double normMin() {
        double min = vectors[0].norm();
        for (int i = 1; i < vectors.length; i++) {
            min = Math.min(min, vectors[i].norm());
        }
        return min;
    }

    /**
     * Lấy ra mảng các vector được sắp xếp theo thứ tự của chuẩn.
     * Nếu order là true thì mảng đầu ra là các vector có chuẩn tăng dần.
     * Nếu order là false thì mảng đầu ra là các vector có chuẩn giảm dần.
     *
     * @return mảng các vector theo thứ tự mảng tăng dần.
     */
    public MyVector[] sortNorm(boolean order) {
        MyVector[] sortedVectors = vectors.clone();
        for (int i = 0; i < sortedVectors.length - 1; i++) {
            for (int j = i + 1; j < sortedVectors.length; j++) {
                if (order ? (sortedVectors[i].norm() > sortedVectors[j].norm()) : (sortedVectors[i].norm() < sortedVectors[j].norm())) {
                    MyVector temp = sortedVectors[i];
                    sortedVectors[i] = sortedVectors[j];
                    sortedVectors[j] = temp;
                }
            }
        }
        return sortedVectors;
    }

    /**
     * Lọc ra mảng các vector có chuẩn nằm trong đoạn [from, to].
     *
     * @param from
     * @param to
     * @return các vector có chuẩn nằm trong đoạn [from, to]
     */
    public MyVector[] filter(double from, double to) {
        int count = 0;
        for (MyVector vector : vectors) {
            if (vector.norm() >= from && vector.norm() <= to) {
                count++;
            }
        }
        MyVector[] filteredVectors = new MyVector[count];
        int index = 0;
        for (MyVector vector : vectors) {
            if (vector.norm() >= from && vector.norm() <= to) {
                filteredVectors[index++] = vector;
            }
        }
        return filteredVectors;
    }

    /**
     * Lấy ra thông tin rank của các vector trong mảng theo chuẩn.
     * Rank được tính theo quy luật sau, ví dụ
     * - tập [3 1 4] có rank [2.0 1.0 3.0]
     * - tập [3 1 3 5] có các rank [2.5 1.0 4.0] (các phần tử có giá trị bằng nhau có rank
     * được tính bằng trung bình các chỉ số của các phần tử trong tập dữ liệu, chỉ số bắt
     * đầu là 1)
     *
     * @return mảng rank của các vector.
     */
    public double[] rank() {
        int n = vectors.length;
        double[] rank = new double[n];

        // Sắp xếp mảng vectors theo thứ tự tăng dần của chuẩn
        MyVector[] sortedVectors = sortNorm(true);

        // Tính rank cho các vector
        double sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += i + 1;
            count++;
            if (i == n - 1 || sortedVectors[i].norm() != sortedVectors[i + 1].norm()) {
                for (int j = i - count + 1; j <= i; j++) {
                    rank[j] = sum / count;
                }
                sum = 0;
                count = 0;
            }
        }

        return rank;
    }

}
