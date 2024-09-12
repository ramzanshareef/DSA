package Stacks;

import java.util.*;

public class Expressions {
    public static int infixEval(String str) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val = (int) ch;
            if (val >= 48 && val <= 57) {
                nums.push(val - 48);
            } else if (op.size() == 0) {
                op.push(ch);
            } else {
                if (ch == '+' || ch == '-') {
                    int v2 = nums.pop();
                    int v1 = nums.pop();
                    if (op.peek() == '-') {
                        nums.push(v1 - v2);
                    }
                    if (op.peek() == '+') {
                        nums.push(v1 + v2);
                    }
                    if (op.peek() == '*') {
                        nums.push(v1 * v2);
                    }
                    if (op.peek() == '/') {
                        nums.push(v1 / v2);
                    }
                    op.pop();
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = nums.pop();
                        int v1 = nums.pop();
                        if (op.peek() == '*') {
                            nums.push(v1 * v2);
                        }
                        if (op.peek() == '/') {
                            nums.push(v1 / v2);
                        }
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        while (nums.size() > 1) {
            int v2 = nums.pop();
            int v1 = nums.pop();
            if (op.peek() == '-') {
                nums.push(v1 - v2);
            }
            if (op.peek() == '+') {
                nums.push(v1 + v2);
            }
            if (op.peek() == '*') {
                nums.push(v1 * v2);
            }
            if (op.peek() == '/') {
                nums.push(v1 / v2);
            }
            op.pop();
        }
        return nums.peek();
    }
}
