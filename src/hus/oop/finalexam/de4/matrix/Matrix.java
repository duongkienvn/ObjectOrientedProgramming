package hus.oop.finalexam.de4.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private double[][] data;

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    public Matrix(int rows, int columns) {
        /* TODO */
        initRandom(rows, columns);
    }

    public double[][] getData() {
        return data;
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [1, 10]
     *
     * @param rows số hàng, columns số cột
     */
    private void initRandom(int rows, int columns) {
        /* TODO */
        data = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = random.nextDouble() * 10 + 1;
            }
        }
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     *
     * @param row
     * @param col
     * @return
     */
    public double get(int row, int col) {
        /* TODO */
        return data[row][col];
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     *
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, double value) {
        /* TODO */
        data[row][col] = value;
    }

    /**
     * Phương thức sắp xếp các phần tử của ma trận theo thứ tự tăng dần.
     *
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự tăng dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public Matrix getSortedMatrix() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        double elements[] = Arrays.stream(data).flatMapToDouble(Arrays::stream).toArray();
        int index = 0;
        Arrays.sort(elements);
        Matrix sortedMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sortedMatrix.data[i][j] = elements[index++];
            }
        }

        return sortedMatrix;
    }

    /**
     * Phương thức cộng ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public Matrix add(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix sum = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum.set(i, j, this.get(i, j) + that.get(i, j));
            }
        }

        return sum;
    }

    /**
     * Phương thức trừ ma trận hiện tại cho một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public Matrix minus(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix difference = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                difference.set(i, j, this.get(i, j) - that.get(i, j));
            }
        }

        return difference;
    }

    /**
     * Phương thức nhân ma trận hiện tại với một ma trận khác.
     *
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public Matrix multiply(Matrix that) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix product = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += this.get(i, k) * that.get(k, j);
                }
                product.set(i, j, sum);
            }
        }

        return product;
    }

    /**
     * Phương thức nhân ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public Matrix scaled(int value) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, this.get(i, j) * value);
            }
        }

        return result;
    }

    /**
     * Phương thức nhân hàng thứ rowIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có hàng rowIndex bằng hàng rowIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledRow(int value, int rowIndex) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == rowIndex) {
                    result.set(i, j, this.get(i, j) * value);
                } else {
                    result.set(i, j, this.get(i, j));
                }
            }
        }

        return result;
    }

    /**
     * Phương thức nhân cột thứ columnIndex của ma trận với một số vô hướng.
     *
     * @param value
     * @return ma trận mới là ma trận có cột columnIndex bằng cột columnIndex của ma trận hiện tại nhân với một số vô hướng.
     */
    public Matrix scaledColumn(int value, int columnIndex) {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == columnIndex) {
                    result.set(i, j, this.get(i, j) * value);
                } else {
                    result.set(i, j, this.get(i, j));
                }
            }
        }

        return result;
    }

    /**
     * Phương thức hoán đổi hai hàng của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapRows(int firstIndex, int secondIndex) {
        /* TODO */
        double temp[] = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    /**
     * Phương thức hoán đổi hai cột của ma trận.
     *
     * @param firstIndex
     * @param secondIndex
     */
    public void swapColumns(int firstIndex, int secondIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            double temp = data[i][firstIndex];
            data[i][firstIndex] = data[i][secondIndex];
            data[i][secondIndex] = temp;
        }
    }

    /**
     * Phương thức cộng hàng destIndex của ma trận với hàng sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addRow(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data[0].length; i++) {
            data[destIndex][i] += value * data[sourceIndex][i];
        }
    }

    /**
     * Phương thức cộng cột destIndex của ma trận với cột sourceIndex của ma trận được nhân với một số value.
     *
     * @param value
     * @param sourceIndex
     * @param destIndex
     */
    public void addColumn(double value, int sourceIndex, int destIndex) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            data[i][destIndex] += data[i][sourceIndex] * value;
        }
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     *
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public Matrix transpose() {
        /* TODO */
        int rows = data.length;
        int cols = data[0].length;
        Matrix tranpose = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tranpose.set(i, j, this.get(j, i));
            }
        }

        return tranpose;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng (row echelon form)
     * sau khi thực hiện phép khử Gauss.
     *
     * @return ma trận dạng hình thang theo hàng.
     */
    public Matrix gaussianElimination() {
        /* TODO */
        Matrix result = new Matrix(data.length, data[0].length);
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, result.data[i], 0, data[0].length);
        }

        int numRows = result.data.length;
        int numCols = result.data[0].length;
        for (int i = 0; i < numRows; i++) {
            double maxVal = Math.abs(result.data[i][i]);
            int maxRow = i;
            for (int k = i + 1; k < numRows; k++) {
                if (Math.abs(result.data[k][i]) > maxVal) {
                    maxVal = Math.abs(result.data[k][i]);
                    maxRow = k;
                }
            }
            double[] temp = result.data[maxRow];
            result.data[maxRow] = result.data[i];
            result.data[i] = temp;
            for (int k = i + 1; k < numRows; k++) {
                double factor = result.data[k][i] / result.data[i][i];
                for (int j = i; j < numCols; j++) {
                    if (j == i) {
                        result.data[k][j] = 0;
                    } else {
                        result.data[k][j] -= factor * result.data[i][j];
                    }
                }
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ra ma trận dạng hình thang theo hàng rút gọn (reduced row echelon form)
     * sau khi thực hiện phép khử Gauss-Jordan
     *
     * @return
     */
    public Matrix gaussJordanElimination() {
        /* TODO */
        Matrix result = this.gaussianElimination();
        int numRows = result.data.length;
        int numCols = result.data[0].length;
        for (int i = numRows - 1; i >= 0; i--) {
            double divisor = result.data[i][i];
            for (int j = 0; j < numCols; j++) {
                result.data[i][j] /= divisor;
                if (result.data[i][j] == -0.0) {
                    result.data[i][j] = 0;
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                double factor = result.data[k][i];
                for (int j = 0; j < numCols; j++) {
                    result.data[k][j] -= factor * result.data[i][j];
                }
            }
        }
        return result;
    }


    /**
     * Biểu diễn ma trận theo định dạng
     * a11 a12 ... a1n
     * a21 a22 ... a2n
     * ...
     * am1 am2 ... amn
     *
     * @return một chuỗi biểu diễn ma trận.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double val : row) {
                sb.append(String.format("%8.2f", val)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
