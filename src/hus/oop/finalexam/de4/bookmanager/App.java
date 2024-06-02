package hus.oop.finalexam.de4.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /*
        TODO

        Viết code để test cho tất cả các hàm bên dưới.
        Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
        là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
        nộp lên classroom.
         */
        System.out.println("Testing original data:");
        testOriginalData();

        System.out.println("\nTesting sort pages of books in increasing order:");
        testSortPagesOfBookIncreasing();

        System.out.println("\nTesting sort pages of books in decreasing order:");
        testSortPagesOfBookDecreasing();

        System.out.println("\nTesting sort price of books in increasing order:");
        testPriceOfBooksIncreasing();

        System.out.println("\nTesting sort price of books in decreasing order:");
        testPriceOfBooksDecreasing();

        System.out.println("\nTesting filter books with lowest price:");
        testFilterBooksLowestPrice();

        System.out.println("\nTesting filter books with highest price:");
        testFilterBooksHighestPrice();

        System.out.println("\nTesting filter books by author:");
        testFilterBooksOfAuthor();

        System.out.println("\nTesting filter books by publisher:");
        testFilterBooksOfPublisher();

        System.out.println("\nTesting filter books by genre:");
        testFilterBooksOfGenre();
    }

    public static void init() {
        String filePath = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2\\src\\hus\\oop\\" +
                "finalexam\\de4\\data\\books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }
                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);
                Book book = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();
                BookManager.getInstance().append(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void testOriginalData() {
        String studentIds = BookManager.getInstance().titleOfBooksToString(BookManager.getInstance().getBookList());
        System.out.print(studentIds);
    }

    public static void testSortPagesOfBookIncreasing() {
        List<Book> sortedList = BookManager.getInstance().sortPagesIncreasing();
        BookManager.print(sortedList);
    }

    public static void testSortPagesOfBookDecreasing() {
        List<Book> sortedBooks = BookManager.getInstance().sortPagesDecreasing();
        BookManager.print(sortedBooks);
    }

    public static void testPriceOfBooksIncreasing() {
        List<Book> sortedBooks = BookManager.getInstance().sortPriceIncreasing();
        BookManager.print(sortedBooks);
    }

    public static void testPriceOfBooksDecreasing() {
        List<Book> sortedBooks = BookManager.getInstance().sortPriceDecreasing();
        BookManager.print(sortedBooks);
    }

    public static void testFilterBooksLowestPrice() {
        List<Book> filteredBooks = BookManager.getInstance().filterBooksLowestPrice(10);
        BookManager.print(filteredBooks);
    }

    public static void testFilterBooksHighestPrice() {
        List<Book> filteredBooks = BookManager.getInstance().filterBooksHighestPrice(10);
        BookManager.print(filteredBooks);
    }

    public static void testFilterBooksOfAuthor() {
        List<Book> filteredBooks = BookManager.getInstance().filterBooksOfAuthor("Mlodinow Leonard");
        BookManager.print(filteredBooks);
    }

    public static void testFilterBooksOfPublisher() {
        List<Book> filteredBooks = BookManager.getInstance().filterBooksOfPublisher("Random House");
        BookManager.print(filteredBooks);
    }

    public static void testFilterBooksOfGenre() {
        List<Book> filteredBooks = BookManager.getInstance().filterBooksOfGenre("history");
        BookManager.print(filteredBooks);
    }
}
