package Queues;

import java.util.*;

import Queues.Implementation.*;

public class Basics {
    public static void main(String[] args) {
        MeraQueueLL q = new MeraQueueLL();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q.peek());

    }

    static void printQueue(Queue<Integer> q) {
        Queue<Integer> tq = new ArrayDeque<>();
        while (q.size() != 0) {
            System.out.println(q.peek() + " ");
            tq.add(q.poll());
        }
        while (tq.size() != 0) {
            q.add(tq.poll());
        }
    }
}