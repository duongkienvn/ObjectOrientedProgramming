package hus.oop.finalexam.datastructure;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        /*
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [15 - 30], gọi là n.
        - Sinh ra n số nguyên ngẫu nhiên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.

        - Sinh ra n số nguyên ngẫu nhiên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
        */
        System.out.println("Test my stack:");
        testStack();
        System.out.println("\nTest my queue:");
        testQueue();
    }

    public static void testStack() {
        /* TODO */
        MyStack myStack = new MyStack();
        Random random = new Random();
        int n = random.nextInt(16) + 15;

        System.out.println("Pushing to stack:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100);
            myStack.push(value);
            System.out.println("Stack after pushing " + value + ": " + myStack.getStackData().toString());
        }

        System.out.println("\nPopping from stack:");
        while (!myStack.isEmpty()) {
            int value = myStack.pop();
            System.out.println("Stack after popping " + value + ": " + myStack.getStackData().toString());
        }
    }

    public static void testQueue() {
        /* TODO */
        MyQueue queue = new MyQueue();
        Random random = new Random();
        int n = random.nextInt(16) + 15;

        System.out.println("Adding to queue:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100);
            queue.add(value);
            System.out.println("Queue after adding " + value + ": " + queue.getQueueData().toString());
        }

        System.out.println("\nRemoving from queue:");
        while (!queue.isEmpty()) {
            int value = queue.remove();
            System.out.println("Queue after removing " + value + ": " + queue.getQueueData().toString());
        }
    }
}
