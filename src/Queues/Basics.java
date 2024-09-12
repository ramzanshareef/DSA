package Queues;

import java.util.*;

public class Basics {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        printQueue(q);
        reverseQueueK(q, 3);
        System.out.println();
        printQueue(q);

    }

    static void printQueue(Queue<Integer> q) {
        Queue<Integer> tq = new ArrayDeque<>();
        while (q.size() != 0) {
            System.out.print(q.peek() + ", ");
            tq.add(q.poll());
        }
        while (tq.size() != 0) {
            q.add(tq.poll());
        }
    }

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        while (!q.isEmpty()) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
    }

    static void reverseQueueK(Queue<Integer> q, int k) {
        int length = q.size();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < k; i++) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        for (int i = 0; i < length - k; i++) {
            q.add(q.poll());
        }
    }

    public static ArrayList<Integer> rearrangeQueue(int n, Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n / 2; i++) {
            st.push(q.poll());
        }
        for (int i = 0; i < n / 2; i++) {
            q.add(st.pop());
        }
        for (int i = 0; i < n / 2; i++) {
            st.push(q.poll());
        }
        for (int i = 0; i < n / 2; i++) {
            q.add(st.pop());
            q.add(q.poll());
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        return res;
    }

}