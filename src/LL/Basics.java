package LL;

import LL.Implementation.MyLinkedList;

public class Basics {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

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

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast == null || fast.next == null) {
            return false;
        }
        while (fast != null) {
            if (slow == null) {
                return false;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode head = new ListNode(100);
        ListNode t = head;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t2;
                t2 = t2.next;
            }
        }
        if (t1 == null) {
            t.next = t2;
        } else {
            t.next = t1;
        }
        return head.next;
    }

    public void evenOddLL(ListNode head) {
        ListNode headOdd = new ListNode(-1);
        ListNode headEven = new ListNode(-1);
        ListNode tempOdd = headOdd;
        ListNode tempEven = headEven;
        ListNode temp = head;
        while (temp != null) {
            ListNode a = new ListNode(temp.val);
            if (temp.val % 2 == 0) {
                tempEven.next = a;
                tempEven = a;
            } else {
                tempOdd.next = a;
                tempOdd = a;
            }
            temp = temp.next;
        }
    }

}