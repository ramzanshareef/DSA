import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> nge = nextGreaterElementCal(nums2);
        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nge.indexOf(nums1[i]);
        }
        return res;
    }

    private ArrayList<Integer> nextGreaterElementCal(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>(arr.length);
        Stack<Integer> st = new Stack<>();
        res.set(arr.length - 1, -1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res.set(i, -1);
            } else {
                res.set(i, st.peek());
            }
            st.push(arr[i]);
        }
        return res;
    }
}