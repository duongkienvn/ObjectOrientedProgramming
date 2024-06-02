package hus.oop.finalexam.bookmanager;

import java.util.*;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     *
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    /**
     * Thêm book vào cuối danh sách.
     *
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     *
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size())) {
            bookList.add(index, book);
        }
    }

    /**
     * Xóa book ở vị trí index.
     *
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            bookList.remove(index);
        }
    }

    /**
     * Bỏ book như tham số truyền vào.
     *
     * @param book
     */
    public void remove(Book book) {
        /* TODO */
        bookList.remove(book);
    }

    /**
     * Lấy ra book ở vị trí index
     *
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            return bookList.get(index);
        }
        return null;
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     *
     * @return
     */
    public List<Book> sortIncreasingByGenreAndTitle() {
        /* TODO */
        List<Book> sortedList = new LinkedList<>(bookList);
        sortedList.sort(Book::compareTo);
        return sortedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Book> sortIncreasingGenreAndPrice() {
        /* TODO */
        List<Book> sortedList = new LinkedList<>(bookList);

        return sortedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Book> sortDecreasingGenreAndPrice() {
        /* TODO */
        List<Book> sortedList = new LinkedList<>(bookList);
        sortedList.sort((Comparator<Book>) new SortedByDecreasingGenreAndPrice());
        return sortedList;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     *
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        List<Book> sortedList = new LinkedList<>(bookList);
        sortedList.sort(Comparator.comparingDouble(Book::getPrice));
        return sortedList;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     *
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        bookList.sort((left, right) -> Double.compare(right.getPrice(), left.getPrice()));
        return bookList;
    }

    /**
     * Sắp xếp sách theo số trang tăng dần.
     *
     * @return
     */
    public List<Book> sortIncreasingPages() {
        /* TODO */
        bookList.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPages() - o2.getPages();
            }
        });
        return bookList;
    }

    /**
     * Sắp xếp sách theo số trang giảm dần.
     *
     * @return
     */
    public List<Book> sortDecreasingPages() {
        /* TODO */
        List<Book> sortedList = new LinkedList<>(bookList);
        sortedList.sort(Comparator.comparingInt(Book::getPages).reversed());
        return sortedList;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     *
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        /* TODO */
        List<Book> filteredList = sortDecreasingPages();
        return filteredList.subList(0, Math.min(howMany, filteredList.size()));
    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     *
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        /* TODO */;
        List<Book> filteredList = new LinkedList<>();
        for (Book book : bookList) {
            if (book.getPages() > lowerBound) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     *
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        /* TODO */
        List<Book> filteredList = sortIncreasingPages();
        return filteredList.subList(0, Math.min(howMany, filteredList.size()));
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     *
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        /* TODO */
        List<Book> filtereddList = new LinkedList<>();
        for (Book book : bookList) {
            if (book.getPages() < upperBound) {
                filtereddList.add(book);
            }
        }
        return filtereddList;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     *
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> filteredList = new LinkedList<>();
        for (Book book : bookList) {
            if (book.getPublisher().equals(publisher)) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }

    /**
     * Lọc ra những sách theo thể loại.
     *
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> filteredList = new LinkedList<>();
        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }

    /**
     * Lọc ra những sách theo tác giả.
     *
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> filteredList = new LinkedList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                filteredList.add(book);
            }
        }
        return filteredList;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.println(booksString.toString().trim() + "\n]");
    }
}
