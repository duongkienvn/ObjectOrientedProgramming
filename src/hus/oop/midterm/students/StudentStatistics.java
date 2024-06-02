package hus.oop.midterm.students;

public class StudentStatistics {
    private MyList students;

    /**
     * Khởi tạo dữ liệu cho StudentManager.
     */
    public StudentStatistics(MyList data) {
        /* TODO */
        students = data;
    }

    /**
     * Lấy ra danh sách các sinh viên được sắp xếp theo thứ tự phụ thuộc vào tên và họ.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     * @param order
     * @return danh sách các sinh viên đã được sắp xếp
     */
    public MyList sortByFullname(boolean order) {
        /*
         TODO

         - Sửa lại lớp Student để sử dụng MyComparable để thực hiện việc so sánh các Student theo tên và họ.
           Thứ tự đầu tiên phụ thuộc vào tên, nếu tên bằng nhau thì thứ tự phụ thuộc vào họ.

         - Sử dụng tiêu chí so sánh trong MyComparable, viết code để sắp xếp danh sách các sinh viên theo thứ tự
           phụ thuộc tham số order. Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì
           sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách sinh viên mới đã được sắp thứ tự.
         */
        MyList sortedList = new MyArrayList();
        for (int i = 0; i < students.size(); i++) {
            sortedList.append(students.get(i));
        }

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                Student student1 = (Student) sortedList.get(i);
                Student student2 = (Student) sortedList.get(j);
                int comparison = student1.compareTo(student2);

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
     * Lấy ra danh sách các sinh viên được sắp xếp theo average.
     * Chú ý, không thay đổi thứ tự sinh viên trong danh sách gốc.
     * @param order
     * @return
     */
    public MyList sortByAverage(boolean order) {
        /*
         TODO

         - Thêm lớp AverageComparison sử dụng StudentComparator để có thể so sánh các sinh viên theo average.

         - Viết code sử dụng AverageComparison để sắp xếp sinh viên theo thứ tự phụ thuộc tham số order.
           Nếu order là true thì sắp xệp theo thứ tự tăng dần. Nếu order là false thì sắp xếp theo thứ tự giảm dần.

         - Trả ra danh sách các sinh viên mới đã được sắp xếp.
         */
        MyList sortedList = new MyArrayList();
        for (int i = 0; i < students.size(); i++) {
            sortedList.append(students.get(i));
        }

        StudentComparator studentComparator = new AverageComparison();
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                Student student1 = (Student) sortedList.get(i);
                Student student2 = (Student) sortedList.get(j);
                int comparison = studentComparator.compare(student1, student2);

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
