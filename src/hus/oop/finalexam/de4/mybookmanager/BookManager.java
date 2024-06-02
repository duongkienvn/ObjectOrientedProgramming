package hus.oop.finalexam.de4.mybookmanager;

public class BookManager {
    // Singleton pattern
    private static BookManager instance;

    private MyList bookList;

    private BookManager() {
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        /* TODO */
        return this.bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.append(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        bookList.insert(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return (Book) bookList.get(index);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự số trang tăng dần.
     * @return
     */
    public MyList sortPagesIncreasing() {
        /* TODO */
        MyList sortedList = copy();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Book currentBook = (Book) sortedList.get(j);
                Book minBook = (Book) sortedList.get(minIndex);
                if (currentBook.getPages() < minBook.getPages()) {
                    minIndex = j;
                }
            }
            Object temp = sortedList.get(i);
            sortedList.set(sortedList.get(minIndex), i);
            sortedList.set(temp, minIndex);
        }
        return sortedList;
    }

    /**
     * Sắp xếp book theo thứ tự số trang giảm dần.
     * @return
     */
    public MyList sortPagesDecreasing() {
        /* TODO */
        MyList sortedList = copy();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < size; j++) {
                Book currentBook = (Book) sortedList.get(j);
                Book maxBook = (Book) sortedList.get(maxIndex);
                if (currentBook.getPages() > maxBook.getPages()) {
                     maxIndex = j;
                }
            }
            Object temp = sortedList.get(i);
            sortedList.set(sortedList.get(maxIndex), i);
            sortedList.set(temp, maxIndex);
        }
        return sortedList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá tăng dần.
     * @return
     */
    public MyList sortPriceIncreasing() {
        /* TODO */
        MyList sortedList = copy();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                Book currentBook = (Book) sortedList.get(j);
                Book minBook = (Book) sortedList.get(minIndex);
                if (currentBook.getPrice() < minBook.getPrice()) {
                    minIndex = j;
                }
            }
            Object temp = sortedList.get(i);
            sortedList.set(sortedList.get(minIndex), i);
            sortedList.set(temp, minIndex);
        }
        return sortedList;
    }

    /**
     * Sắp xếp sách theo thứ tự giá giảm dần.
     * @return
     */
    public MyList sortPriceDecreasing() {
        /* TODO */
        MyList sortedList = copy();
        int size = sortedList.size();
        for (int i = 0; i < size - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < size; j++) {
                Book currentBook = (Book) sortedList.get(j);
                Book maxBook = (Book) sortedList.get(maxIndex);
                if (currentBook.getPrice() > maxBook.getPrice()) {
                    maxIndex = j;
                }
            }
            Object temp = sortedList.get(i);
            sortedList.set(sortedList.get(maxIndex), i);
            sortedList.set(temp, maxIndex);
        }
        return sortedList;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        /* TODO */
        MyList filtedList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) instanceof Book) {
                Book book = (Book) bookList.get(i);
                if (book.getPublisher().equals(publisher)) {
                    filtedList.append(bookList.get(i));
                }
            }
        }
        return filtedList;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        /* TODO */
        MyList filtedList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) instanceof Book) {
                Book book = (Book) bookList.get(i);
                if (book.getGenre().equals(genre)) {
                    filtedList.append(bookList.get(i));
                }
            }
        }
        return filtedList;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        /* TODO */
        MyList filtedList = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) instanceof Book) {
                Book book = (Book) bookList.get(i);
                if (book.getAuthor().equals(author)) {
                    filtedList.append(bookList.get(i));
                }
            }
        }
        return filtedList;
    }

    public MyList copy() {
        MyList result = new MyArrayList();
        for (int i = 0; i < bookList.size(); i++) {
            result.append(bookList.get(i));
        }
        return result;
    }

    public static String titleOfBooksToString(MyList bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(MyList bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
