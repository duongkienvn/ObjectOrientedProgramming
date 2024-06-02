package hus.oop.midterm.books;

public class BookManager {
    private MyList books;

    /**
     * Khởi tạo dữ liệu cho BookManager.
     */
    public BookManager(MyList data) {
        /* TODO */
        this.books = data;
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo thứ tự title.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByTitle(boolean order) {
        /*
         TODO

         - Sửa lại lớp Book để sử dụng BookComparable để thực hiện việc so sánh các Book theo title.

         - Sử dụng tiêu chí so sánh trong BookComparable, viết code để sắp xếp danh sách các sách theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp thứ tự.
         */

        MyList sortedList = new MyArrayList();
        for (int i = 0; i < books.size(); i++) {
            sortedList.append(books.get(i));
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                Book book1 = (Book) sortedList.get(i);
                Book book2 = (Book) sortedList.get(j);
                int comparison = book1.compareTo(book2);

                if (order && comparison > 0 || !order && comparison < 0) {
                    Object temp = sortedList.get(i);
                    sortedList.set(sortedList.get(j), i);
                    sortedList.set(temp, j);
                }
            }
        }

        return sortedList;
    }

    /**
     * Lấy ra danh sách các sách được sắp xếp theo pages.
     * Chú ý, không thay đổi thứ tự sách trong danh sách gốc.
     * @param order
     * @return danh sách các sách đã được sắp xếp.
     */
    public MyList sortByPageNumber(boolean order) {
        /*
         TODO

         - Thêm lớp PageComparison sử dụng BookComparator để có thể so sánh các sách theo pages.

         - Viết code sử dụng PageComparison để sắp xếp sách theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách mới các sách đã được sắp xếp.
         */

        MyList sortedList = new MyArrayList();
        for (int i = 0; i < books.size(); i++) {
            sortedList.append(books.get(i));
        }

        BookComparator bookComparator = new PageComparison();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                Book left = (Book) sortedList.get(i);
                Book right = (Book) sortedList.get(j);
                int comparison = bookComparator.compare(left, right);

                if (order && comparison > 0 || !order && comparison < 0) {
                    Object temp = sortedList.get(i);
                    sortedList.set(sortedList.get(j), i);
                    sortedList.set(temp, j);
                }
            }
        }

        return sortedList;
    }
}
