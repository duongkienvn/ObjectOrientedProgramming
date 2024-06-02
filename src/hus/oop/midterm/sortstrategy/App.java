package hus.oop.midterm.sortstrategy;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        /* TODO */
        // Tạo một mảng các số tự nhiên, các số tự nhiên được sinh ngẫu nhiên
        // In ra mảng vừa tạo theo định dạng, ví dụ [1 2 3 4 5].
        // Sắp xếp mảng theo thứ tự tăng dần sử dụng các thuật toán sắp xếp khác nhau.
        // In ra mảng sau khi sắp xếp.
        // In ra số lần đổi vị trí trong thuật toán đang sử dụng.
        // Ví dụ:
        // Using Bubble Sort Algorithm:
        // Before sorting: [5 4 3 2 1]
        // After sorting: [1 2 3 4 5]
        // Number of swap: 10

        // Using Selection Sort Algorithm:
        // Before sorting: [5 4 3 2 1]
        // After sorting: [1 2 3 4 5]
        // Number of swap: 10

        // Kết quả chạy chương trình lưu vào file SortStrategy<Mã sinh viên>.txt và nộp cùng source code.
        int data[] = generateRandomArray(10);

        System.out.println("Using Bubble Sort Algorithm:");
        SortStrategy.getInstance().setSortee(new BubbleSort());
        testSorting(new BubbleSort(), data.clone());

        System.out.println("\nUsing Selection Sort Algorithm:");
        SortStrategy.getInstance().setSortee(new SelectionSort());
        testSorting(new SelectionSort(), data.clone());

        System.out.println("\nUsing Insertion Sort Algorithm:");
        SortStrategy.getInstance().setSortee(new InsertionSort());
        testSorting(new InsertionSort(), data.clone());
    }

    public static String print(int data[]) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
            if (i != data.length - 1) {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void testSorting(ISort sortAlgorithm, int data[]) {
        System.out.println("Before sorting: " + print(data));
        int swapCount = SortStrategy.getInstance().sort(data);
        System.out.println("After sorting: " + print(data));
        System.out.println("Number of swap: " + swapCount);
    }

    private static int[] generateRandomArray(int length) {
        int array[] = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
