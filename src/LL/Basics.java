package LL;

import LL.Implementation.MyLinkedList;

public class Basics {

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.display();
        ll.deleteAt(0);
        System.out.println();
        ll.display();
        System.out.println();
        System.out.println(ll.head.data);
        System.out.println(ll.tail.data);
    }

}