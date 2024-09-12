package LL;

public class MyDLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static class MyDoubleLL {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtStart(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
            size++;
        }

        void insertAtEnd(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;
            size++;
        }

        void insertAt(int index, int value) {
            int currIndex = 0;
            Node temp = head;
            Node newNode = new Node(value);
            if (index == 0) {
                insertAtStart(value);
                return;
            } else if (index == size) {
                insertAtEnd(value);
                return;
            }
            while (currIndex != index - 1) {
                temp = temp.next;
                currIndex++;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

        int getElementAt(int index) {
            int currIndex = 0;
            if (index == 0) {
                return head.data;
            }
            Node temp = head;
            while (currIndex != index) {
                temp = temp.next;
                currIndex++;
            }
            return temp.data;
        }

        void deleteAt(int index) {
            int currIndex = 0;
            Node temp = head;
            if (index == 0) {
                head = head.next;
                size--;
                return;
            }
            while (currIndex != index - 1) {
                temp = temp.next;
                currIndex++;
            }
            temp.next = temp.next.next;
            if (index == size - 1) {
                tail = temp;
            }
            size--;
            return;
        }
    }

    public static void main(String[] args) {
        MyDoubleLL ll = new MyDoubleLL();
        ll.insertAtEnd(10);
        ll.insertAtEnd(20);
        ll.insertAtEnd(30);
        ll.insertAtEnd(40);
        ll.insertAtEnd(50);
        ll.insertAt(2, 0);
        ll.display();
    }
}