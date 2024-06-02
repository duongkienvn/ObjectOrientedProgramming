package hus.oop.finalexam.de4.matrix;

import java.util.Arrays;
import java.util.Random;

public class MatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận vuông có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Các phần tử của ma trận được khởi tạo ngẫu nhiên có giá trị nằm trong đoạn [1, 10].

        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - Tìm và in ra một ma trận dạng hình thang theo hàng (row echelon form) dùng phép khử Gauss của 2 ma trận.
          - Tìm và in ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form) dùng phép khử Gauss-Jordan.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        Random random = new Random();
        int size = random.nextInt(6) + 5;

        Matrix matrix1 = new SquareMatrix(size);
        Matrix matrix2 = new SquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        System.out.println("Transpose of Matrix 1:");
        System.out.println(matrix1.transpose());

        System.out.println("Transpose of Matrix 2:");
        System.out.println(matrix2.transpose());

        SquareMatrix squareMatrix1 = (SquareMatrix) matrix1;
        System.out.println("Principal Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(squareMatrix1.principalDiagonal()));

        System.out.println("Secondary Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(squareMatrix1.secondaryDiagonal()));

        SquareMatrix squareMatrix2 = (SquareMatrix) matrix2;
        System.out.println("Principal Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(squareMatrix2.principalDiagonal()));

        System.out.println("Secondary Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(squareMatrix2.secondaryDiagonal()));

        System.out.println("Sum of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.add(matrix2));

        System.out.println("Difference of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.minus(matrix2));

        System.out.println("Product of Matrix 1 and Matrix 2:");
        System.out.println(matrix1.multiply(matrix2));

        System.out.println("Row Echelon Form of Matrix 1:");
        System.out.println(matrix1.gaussianElimination());

        System.out.println("Reduced Row Echelon Form of Matrix 1:");
        System.out.println(matrix1.gaussJordanElimination());

        System.out.println("Row Echelon Form of Matrix 2:");
        System.out.println(matrix2.gaussianElimination());

        System.out.println("Reduced Row Echelon Form of Matrix 2:");
        System.out.println(matrix2.gaussJordanElimination());
    }
}
