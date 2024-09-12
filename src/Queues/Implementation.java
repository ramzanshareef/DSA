package Queues;

import java.util.ArrayList;

import LL.Implementation.MyLinkedList;

public class Implementation {
    public static class MeraQueue {
        private ArrayList<Integer> arr;

        MeraQueue() {
            arr = new ArrayList<>();
        }

        void add(int val) {
            arr.add(val);
        }

        int peek() {
            return arr.get(0);
        }

        int poll() {
            return arr.remove(0);
        }

        void display() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
    }

    public static class MeraQueueLL {
        private MyLinkedList ll;

        MeraQueueLL() {
            ll = new MyLinkedList();
        }

        void add(int val) {
            ll.insertAtEnd(val);
        }

        int peek() {
            return ll.getElementAt(0);
        }

        int poll() {
            int val = ll.getElementAt(0);
            ll.deleteAt(0);
            return val;
        }

        void display() {
            ll.display();
        }
    }

}