package hus.oop.lab8.collections.set;

import com.sun.source.tree.Tree;

import java.util.*;

public class Sets {
    public static Set<Integer> intersectionManual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new LinkedHashSet<>();
        for (int i : first) {
            if (second.contains(i)) {
                intersection.add(i);
            }
        }

        return intersection;
    }

    public static Set<Integer> unionManual(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new LinkedHashSet<>();
        for (int i : first) {
            union.add(i);
        }

        for (int i : second) {
            union.add(i);
        }

        return union;
    }

    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> intersection = new LinkedHashSet<>(first);
        intersection.retainAll(second);
        return intersection;
    }

    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> union = new LinkedHashSet<>(first);
        union.addAll(second);
        return union;
    }

    public static List<Integer> toList(Set<Integer> source) {
        return new ArrayList<>(source);
    }

    public static List<Integer> removeDuplicates(List<Integer> source) {
        return new ArrayList<>(new LinkedHashSet<>(source));
    }

    public static List<Integer> removeDuplicatesManual(List<Integer> source) {
        List<Integer> removeDuplicates = new ArrayList<>();
        int length = source.size();
        for (int i = 0; i < length; i++) {
            boolean check = false;
            for (int j = 0; j < i; j++) {
                if (source.get(i) == source.get(j)) {
                    check = true;
                }
            }
            if (!check) {
                removeDuplicates.add(source.get(i));
            }
        }

        return removeDuplicates;
    }

    public static String firstRecurringCharacter(String s) {
        Set<Character> recurring = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (recurring.contains(c)) {
                return String.valueOf(c);
            }
            recurring.add(c);
        }

        return null;
    }

    public static Set<Character> allRecurringChars(String s) {
        Set<Character> allRecurringChars = new LinkedHashSet<>();
        for (char c : s.toCharArray()) {
            allRecurringChars.add(c);
        }

        return allRecurringChars;
    }

    public static Integer[] toArray(Set<Integer> source) {
        return source.toArray(new Integer[0]);
    }

    public static int getFirst(TreeSet<Integer> source) {
        return source.getFirst();
    }

    public static int getLast(TreeSet<Integer> source) {
        return source.getLast();
    }

    public static int getGreater(TreeSet<Integer> source, int value) {
        Integer greater = source.higher(value);
        return (greater != null) ? greater : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {

    }
}
