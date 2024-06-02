package hus.oop.finalexam.de4.matrix;

public class SquareMatrix extends Matrix {

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     * @param size
     */
    public SquareMatrix(int size) {
        /* TODO */
        super(size, size);
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public double[] principalDiagonal() {
        /* TODO */
        double diagonal[] = new double[getData().length];
        for (int i = 0; i < getData().length; i++) {
            diagonal[i] = get(i, i);
        }
        return diagonal;
    }

    /**
     * Phương thức lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public double[] secondaryDiagonal() {
        /* TODO */
        double diagonal[] = new double[getData().length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonal[i] = get(i, getData().length - i - 1);
        }
        return diagonal;
    }
}
