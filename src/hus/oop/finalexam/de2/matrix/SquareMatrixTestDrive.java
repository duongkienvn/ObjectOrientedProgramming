package hus.oop.finalexam.de2.matrix;

import java.util.Arrays;
import java.util.Random;

public class SquareMatrixTestDrive {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */
        Random random = new Random();
        int size = random.nextInt(6) + 5;

        SquareMatrix matrix1 = new SquareMatrix(size);
        SquareMatrix matrix2 = new SquareMatrix(size);

        System.out.println("Matrix 1:");
        System.out.println(matrix1);
        System.out.println("\nTranspose of Matrix 1:");
        System.out.println(matrix1.transpose());

        System.out.println("\nMatrix 2:");
        System.out.println(matrix2);
        System.out.println("\nTranspose of Matrix 2:");
        System.out.println(matrix2.transpose());

        System.out.println("\nPrincipal Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(matrix1.principalDiagonal()));

        System.out.println("\nSecondary Diagonal of Matrix 1:");
        System.out.println(Arrays.toString(matrix1.secondaryDiagonal()));

        System.out.println("\nrincipal Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(matrix2.principalDiagonal()));

        System.out.println("\nSecondary Diagonal of Matrix 2:");
        System.out.println(Arrays.toString(matrix2.secondaryDiagonal()));

        SquareMatrix sumMatrix = matrix1.add(matrix2);
        System.out.println("\nSum of Matrix 1 and Matrix 2:");
        System.out.println(sumMatrix);

        SquareMatrix diffMatrix = matrix1.minus(matrix2);
        System.out.println("\nDifference of Matrix 1 and Matrix 2:");
        System.out.println(diffMatrix);

        SquareMatrix prodMatrix = matrix1.multiply(matrix2);
        System.out.println("\nProduct of Matrix 1 and Matrix 2:");
        System.out.println(prodMatrix);

        System.out.println("\nPrime numbers in Matrix 1:");
        System.out.println(Arrays.toString(matrix1.primes()));

        System.out.println("\nPrime numbers in Matrix 2:");
        System.out.println(Arrays.toString(matrix2.primes()));
    }
}
