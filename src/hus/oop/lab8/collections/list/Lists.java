package hus.oop.lab8.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    public static void insertFirst(List<Integer> list, int value) {
        list.addFirst(value);
    }

    public static void insertLast(List<Integer> list, int value) {
        list.addLast(value);
    }

    /**
     * Function to replace the 3rd element of list with a given value
     */
    public static void replace(List<Integer> list, int value) {
        if (list.size() >= 3) {
            list.set(2, value);
        }
    }

    public static void removeThird(List<Integer> list) {
        list.remove(2);
    }

    public static void removeEvil(List<Integer> list) {
        list.remove(666);
    }

    public static List<Integer> generateSquare() {
        List<Integer> square = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            square.add(i * i);
        }

        return square;
    }

    public static boolean contains(List<Integer> list, int value) {
        if (list.contains(value)) {
            return true;
        }
        return false;
    }

    public static void copy(List<Integer> source, List<Integer> target) {
        target.clear();
        for (int i = 0; i < source.size(); i++) {
            target.set(i, source.get(i));
        }
    }

    public static void reverse(List<Integer> list) {
        list.reversed();
    }

    public static void reverseManual(List<Integer> list) {
        int listSize = list.size();
        int left = 0, right = listSize - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    public static void insertBeginningEnd(LinkedList<Integer> list, int value) {
        list.addFirst(value);
        list.addLast(value);
    }

    public static void main(String[] args) {

    }
}
