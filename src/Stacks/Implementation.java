package Stacks;

public class Implementation {

    public static class MeraStack {
        private int capacity;
        private int arr[];
        private int size;

        MeraStack(int capacity) {
            this.capacity = capacity;
            arr = new int[this.capacity];
        }

        int peek() {
            if (size <= 0) {
                System.out.println("Stack Underflow, returning -1");
                return -1;
            }
            return arr[size - 1];
        }

        void push(int val) {
            if (size == capacity) {
                System.out.println("Stack Overflow!");
                return;
            }
            arr[size++] = val;
        }

        int pop() {
            int topVal = arr[size];
            arr[size--] = 0;
            return topVal;
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == capacity;
        }

        int capacity() {
            return capacity;
        }

        void display() {
            int i = 0;
            while (i < size) {
                System.out.print(arr[i++] + " ");
            }
        }

    }

    public static class StackUsingLL {
        private Node head;
        private int size;

        int peek() {
            return head.data;
        }

        int size() {
            return size;
        }

        void push(int val) {
            Node newNode = new Node(val);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        int pop() {
            int top = head.data;
            if (head == null || head.next == null) {
                head = null;
            }
            head = head.next;
            return top;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}