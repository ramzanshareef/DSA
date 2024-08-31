package LL;

public class Implementation {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class MyLinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtStart(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                tail = newNode;
            } else {
                newNode.next = head;
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
            temp.next = newNode;
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

    // public static void printLLIter(Node n) {
    // while (n != null) {
    // System.out.print(n.data + " ");
    // n = n.next;
    // }
    // }

    // public static void printLLRec(Node n) {
    // if (n == null)
    // return;
    // System.out.print(n.data + " ");
    // printLLIter(n.next);
    // }

    // public static int getLLLengthIter(Node head) {
    // int length = 0;
    // while (head != null) {
    // length++;
    // head = head.next;
    // }
    // return length;
    // }

    // public static int getLLLengthRec(Node head) {
    // if (head == null) {
    // return 0;
    // }
    // return 1 + getLLLengthIter(head.next);
    // }
}