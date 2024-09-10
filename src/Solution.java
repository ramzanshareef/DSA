/**
 * Solution
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    private int gcdUsingEuclid(int x, int y) {
        if (y == 0)
            return x;
        return gcdUsingEuclid(y, x % y);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int gcd = gcdUsingEuclid(head.val, head.next.val);
        ListNode newNode = new ListNode(gcd);
        newNode.next = head.next;
        head.next = newNode;
        head.next.next = insertGreatestCommonDivisors(head.next.next);
        return head;
    }
}