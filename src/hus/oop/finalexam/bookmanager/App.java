package hus.oop.finalexam.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();
        testOriginalData();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_BookManager>.txt (Ví dụ, NguyenVanA_123456_BookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookManager>.zip (Ví dụ, NguyenVanA_123456_BookManager.zip),
          nộp lên classroom.
         */

        System.out.println("\nTestSortIncreasingByGenreAndTitle:");
        testSortIncreasingByGenreAndTitle();
//        System.out.println("\nTestSortIncreasingGenreAndPrice:");
//        testSortIncreasingGenreAndPrice();
        System.out.println();
        testSortDecreasingGenreAndPrice();

        System.out.println();
        testFilterBooksHighestPages();
        System.out.println();
        testFilterBooksLowestPages();
        System.out.println();
        testFilterBooksOfAuthor();
        System.out.println();
        testFilterBooksOfGenre();
        System.out.println();
        testFilterBooksOfPublisher();
    }

    public static void init() {
        String filePath = "C:\\Users\\Dell\\eclipse-workspace\\OOP_ki_2" +
                "\\src\\hus\\oop\\finalexam\\bookmanager\\data\\books.csv";
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
                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào bookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double prices = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(prices)
                        .withPublisher(publisher)
                        .build();
                bookManager.append(newBook);
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
        List<Book> books = bookManager.getBookList();
        bookManager.print(books);
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     */
    public static void testSortIncreasingByGenreAndTitle() {
        List<Book> sorted = bookManager.sortIncreasingByGenreAndTitle();
        bookManager.print(sorted);
    }

    /**
     * Test sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, sau đó theo giá giảm dần.
     */
    public static void testSortIncreasingGenreAndPrice() {
        /* TODO */
        List<Book> sorted = bookManager.sortIncreasingGenreAndPrice();
        bookManager.print(sorted);
    }

    /**
     * Test sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, sau đó theo giá giảm dần.
     */
    public static void testSortDecreasingGenreAndPrice() {
        /* TODO */
        List<Book> sorted = bookManager.sortDecreasingGenreAndPrice();
        bookManager.print(sorted);
    }

    /**
     * Test sắp xếp sách theo giá tăng dần.
     */
    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        List<Book> sorted = bookManager.sortIncreasingPrice();
        bookManager.print(sorted);
    }

    /**
     * Test sắp xếp sách theo giá giảm dần
     */
    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        List<Book> sorted = bookManager.sortDecreasingPrice();
        bookManager.print(sorted);
    }

    /**
     * Test lọc sách có số trang ít nhat.
     */
    public static void testFilterBooksLowestPages() {
        /* TODO */
        List<Book> filtered = bookManager.filterBookLowestPages(10);
        bookManager.print(filtered);
    }

    /**
     * Test lọc sách có số trang nhiều nhât
     */
    public static void testFilterBooksHighestPages() {
        /* TODO */
        List<Book> filtered = bookManager.filterHighestPages(10);
        bookManager.print(filtered);
    }

    /**
     * Test lọc sách theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        List<Book> filtered = bookManager.filterBooksOfAuthor("Foreman John");
        bookManager.print(filtered);
    }

    /**
     * Test lọc sách theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        List<Book> filtered = bookManager.filterBooksOfPublisher("Penguin");
        bookManager.print(filtered);
    }

    /**
     * Test lọc sách theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        List<Book> filtered = bookManager.filterBooksOfGenre("economics");
        bookManager.print(filtered);
    }
}
