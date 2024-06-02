package hus.oop.finalexam.bookmanager;

public class SortedByIncreasingGenreAndPrice implements MyBookComparator {
    @Override
    public int compare(Book left, Book right) {
        int genreComparison = left.getTitle().compareTo(right.getTitle());
        if (genreComparison != 0) {
            return genreComparison;
        }
        return Double.compare(right.getPrice(), left.getPrice());
    }
}
