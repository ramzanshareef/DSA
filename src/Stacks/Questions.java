package Stacks;

import java.util.*;

public class Questions {
    public static ArrayList<Integer> removeSubArrayWithMoreThanOr2SameEle(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                continue;
            }
            if (arr[i] == st.peek()) {
                st.push(arr[i]);
            } else {
                if (st.size() < 2) {
                    res.add(st.peek());
                }
                while (!st.isEmpty()) {
                    st.pop();
                }
                st.push(arr[i]);
            }
        }
        if (st.size() > 0) {
            res.add(st.peek());
        }
        return res;
    }

    public static int[] nextGreaterElement(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        res[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }

    public static int[] previousGreaterElement(int arr[]) {
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        res[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }

    public static int[] calculateSpan(int price[], int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            while (st.size() != 0 && price[st.peek()] <= price[i]) {
                st.pop();
            }
            res[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return res;
    }

    public static int[] nextSmallerElement(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        res[arr.length - 1] = -1;
        st.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int[] previousSmallerElement(int arr[]) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        res[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() != 0 && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
}