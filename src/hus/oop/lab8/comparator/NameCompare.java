package hus.oop.lab8.comparator;

import java.util.Comparator;

public class NameCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie left, Movie right) {
        return left.compareTo(right);
    }
}
