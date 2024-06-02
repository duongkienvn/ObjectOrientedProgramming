package hus.oop.finalexam.datastructure;

public class LinkedListMyList extends AbstractMyList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public LinkedListMyList() {
        this.start = null;
        this.end = null;
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     *
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        if (!checkBoundaries(0, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeByIndex(index).data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     *
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        if (!checkBoundaries(0, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        getNodeByIndex(index).data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            newNode.next = start;
            start = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     *
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        Node newNode = new Node(value);
        if (end == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     *
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (!checkBoundaries(0, size)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node newNode = new Node(value);
            Node previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     *
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(0, size - 1)) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            start = start.next;
            if (start == null) {
                end = null;
            }
        } else {
            Node previous = getNodeByIndex(index - 1);
            previous.next = previous.next.next;
            if (previous.next == null) {
                end = previous;
            }
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     *
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     *
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        int result[] = new int[size];
        int index = 0;
        Node current = start;

        while (current != null) {
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }
}
