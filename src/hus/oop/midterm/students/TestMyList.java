package hus.oop.midterm.students;

public class TestMyList {
    public static void main(String[] args) {
        /*
         TODO
         - Chạy demo các hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <Ten_MaSinhVien_MyList>.txt
           (ví dụ, NguyenVanA_123456_MyList.txt)
         - Nộp kết quả chạy chương trình (file text trên) cùng với các file source code.
         */

        System.out.println("testMyArrayList:");
        testMyArrayList();
        System.out.println("\ntestMyLinkedList:");
        testMyLinkedList();
        System.out.println("\ntestIterator:");
        MyList myList = createMyList();
        testIterator(myList);
    }

    public static void testMyArrayList() {
        /*
         TODO

         - Tạo ra một list kiểu MyArrayList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        MyList myList = new MyArrayList();
        myList.append(new Student("kien", "duong", 100));
        myList.append(new Student("cuong", "cong", 200));
        myList.append(new Student("john", "alex", 300));
        myList.append(new Student("nam", "vu", 500));
        myList.append(new Student("tu", "nguyen", 800));
        myList.append(new Student("nghia", "nguyen", 250));
        myList.append(new Student("hung", "pham", 130));
        myList.append(new Student("toan", "khuc", 60));
        myList.append(new Student("bac", "chi", 50));
        myList.append(new Student("dat", "vo", 660));

        StudentStatistics studentStatistics = new StudentStatistics(myList);
        MyList increasingByName = studentStatistics.sortByFullname(true);
        MyList decreasingByName = studentStatistics.sortByFullname(false);
        MyList increasingByAverage = studentStatistics.sortByAverage(true);
        MyList decreasingByAverage = studentStatistics.sortByAverage(false);

        System.out.println("sorting by increasing name");
        System.out.println(increasingByName);
        System.out.println("sorting by decreasing name");
        System.out.println(decreasingByName);
        System.out.println("sorting by increasing average");
        System.out.println(increasingByAverage);
        System.out.println("sorting by decreasing average");
        System.out.println(decreasingByAverage);
    }

    public static void testMyLinkedList() {
        /*
         TODO

         - Tạo ra một list kiểu MyLinkedList có ít nhất 10 Student.

         - Sử dụng StudentStatistics để
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần theo tên và họ.
             + Sắp xếp và in ra danh sách các Student theo thứ tự tăng dần về average.
             + Sắp xếp và in ra danh sách các Student theo thứ tự giảm dần về average.
         */
        MyList myList = new MyLinkedList();
        myList.append(new Student("kien", "duong", 100));
        myList.append(new Student("cuong", "cong", 200));
        myList.append(new Student("john", "alex", 300));
        myList.append(new Student("nam", "vu", 500));
        myList.append(new Student("tu", "nguyen", 800));
        myList.append(new Student("nghia", "nguyen", 250));
        myList.append(new Student("hung", "pham", 130));
        myList.append(new Student("toan", "khuc", 60));
        myList.append(new Student("bac", "chi", 50));
        myList.append(new Student("dat", "vo", 660));

        StudentStatistics studentStatistics = new StudentStatistics(myList);
        MyList increasingByName = studentStatistics.sortByFullname(true);
        MyList decreasingByName = studentStatistics.sortByFullname(false);
        MyList increasingByAverage = studentStatistics.sortByAverage(true);
        MyList decreasingByAverage = studentStatistics.sortByAverage(false);

        System.out.println("sorting by increasing name");
        System.out.println(increasingByName);
        System.out.println("sorting by decreasing name");
        System.out.println(decreasingByName);
        System.out.println("sorting by increasing average");
        System.out.println(increasingByAverage);
        System.out.println("sorting by decreasing average");
        System.out.println(decreasingByAverage);
    }

    public static void testIterator(MyList myList) {
        /*
         TODO
         Sử dụng iterator duyệt qua tất cả các phần tử trong danh sách myList và in ra thông tin về phần tử đó.
         */

        MyIterator myIterator = myList.iterator();
        while (myIterator.hasNext()) {
            Object element = myIterator.next();
            if (element instanceof Student) {
                Student student = (Student) element;
                System.out.println(student);
            }
        }
    }

    public static MyList createMyList() {
        MyList myList = new MyLinkedList();
        myList.append(new Student("kien", "duong", 100));
        myList.append(new Student("cuong", "cong", 200));
        myList.append(new Student("john", "alex", 300));
        myList.append(new Student("nam", "vu", 500));
        myList.append(new Student("tu", "nguyen", 800));
        myList.append(new Student("nghia", "nguyen", 250));
        myList.append(new Student("hung", "pham", 130));
        myList.append(new Student("toan", "khuc", 60));
        myList.append(new Student("bac", "chi", 50));
        myList.append(new Student("dat", "vo", 660));

        return myList;
    }
}
