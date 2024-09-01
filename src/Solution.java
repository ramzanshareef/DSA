public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode middleNode = head;
        ListNode fast = head;
        if (fast.next == null) {
            head = null;
            return null;
        }
        while (fast.next.next.next != null && fast.next.next != null) {
            fast = fast.next.next;
            middleNode = middleNode.next;
        }
        middleNode.next = middleNode.next.next;
        return head;
    }
}