package Stacks;

import java.util.Stack;
import Stacks.Implementation.StackUsingLL;

public class BasicsOfStacks {
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // stack.push(10);
        // stack.push(20);
        // stack.push(30);
        // stack.push(40);
        // System.out.println(stack);
        // reverseStack(stack);
        // System.out.println(stack);

        // MeraStack st = new MeraStack(10);
        // st.push(10);
        // st.push(20);
        // st.push(30);
        // st.push(40);
        // st.display();
        // System.out.println("\n" + st.peek());
        // st.pop();
        // st.display();
        // System.out.println("\n" + st.peek());

        StackUsingLL st = new StackUsingLL();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.display();
        System.out.println(st.pop());
        st.display();
        System.out.println(st.peek());
    }

    public static void displayStackRevRec(Stack<Integer> st) {
        if (st.size() == 1) {
            System.out.print(st.peek() + " ");
            return;
        }
        int top = st.pop();
        displayStackRevRec(st);
        System.out.print(top + " ");
        st.push(top);
    }

    public static void pushAtBottom(Stack<Integer> st, int x) {
        if (st.size() == 0) {
            st.push(x);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, x);
        st.add(top);
    }

    public static void reverseStack(Stack<Integer> st) {
        if (st.size() == 1) {
            return;
        }
        int top = st.pop();
        reverseStack(st);
        pushAtBottom(st, top);
    }
}