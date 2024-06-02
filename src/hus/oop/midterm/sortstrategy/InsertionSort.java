package hus.oop.midterm.sortstrategy;

public class InsertionSort implements ISort {
    @Override
    public int sort(int[] data) {
        /* TODO */
        int length = data.length;
        int swapCount = 0;
        for (int i = 1; i < length; i++) {
            int key = data[i];
            int index = i - 1;
            while (index >= 0 && key < data[index]) {
                data[index + 1] = data[index];
                index--;
                swapCount++;
            }
            data[index + 1] = key;
        }
        return swapCount;
    }
}
