package Stacks;

import java.util.*;

class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        long q = (long) val;
        if (st.size() == 0) {
            st.push(q);
            min = q;
        } else if (q >= min) {
            st.push(q);
        } else {
            st.push(2 * q - min);
            min = q;
        }
    }

    public void pop() {
        if (st.size() == 0)
            return;
        else if (st.peek() >= min) {
            st.pop();
        } else {
            min = 2 * min - st.peek();
            st.pop();
        }
    }

    public int top() {
        if (st.size() == 0) {
            return -1;
        }
        long peek = st.peek();
        if (peek >= min) {
            return (int) peek;
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        if (st.size() == 0) {
            return -1;
        }
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */