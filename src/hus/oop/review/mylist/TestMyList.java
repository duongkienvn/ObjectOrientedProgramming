package hus.oop.review.mylist;

public class TestMyList {
    public static void main(String[] args) {
        /*
         * TODO
         * Chạy demo các hàm test.
         */
        System.out.println("Test My ArrayList: ");
        testMyArrayList();
        System.out.println("\nTest My LinkedList: ");
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyArrayList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        MyList list = new MyArrayList();
        list.append(1.5);
        list.append(2.5);
        list.append(3.5);
        list.append(4.5);
        list.append(5.5);
        System.out.println("Data in my list: " + list);

        BasicStatistic basicStatistic = new BasicStatistic(list);
        System.out.println("Max data in my list: " + basicStatistic.max());
        System.out.println("Min data in my list: " + basicStatistic.min());
        System.out.println("Mean data: " + basicStatistic.mean());
        System.out.println("Variance data: " + basicStatistic.variance());

        MyIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void testMyLinkedList() {
        /*
         * TODO
         * Tạo ra một list kiểu MyLinkedList có các phần tử dữ liệu kiểu Double.
         * Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
         * In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        MyLinkedList list = new MyLinkedList();
        list.append(1.5);
        list.append(2.5);
        list.append(3.5);
        list.append(4.5);
        list.append(5.5);
        System.out.println("Data in my list: " + list);

        BasicStatistic basicStatistic = new BasicStatistic(list);
        System.out.println("Max data in my list: " + basicStatistic.max());
        System.out.println("Min data in my list: " + basicStatistic.min());
        System.out.println("Mean data: " + basicStatistic.mean());
        System.out.println("Variance data: " + basicStatistic.variance());

        MyIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
