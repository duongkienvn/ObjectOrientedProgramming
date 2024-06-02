package hus.oop.finalexam.bookmanager;

public class SortedByDecreasingGenreAndPrice implements MyBookComparator {
    @Override
    public int compare(Book left, Book right) {
        int comparison = right.getGenre().compareTo(left.getGenre());
        if (comparison != 0) {
            return comparison;
        }
        return Double.compare(right.getPrice(), left.getPrice());
    }
}
