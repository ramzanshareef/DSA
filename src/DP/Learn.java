package DP;

import java.util.*;

@SuppressWarnings("unused")
public class Learn {
    static int runs = 0;

    public static void main(String[] args) {
        // int n = 5;
        // int dp[] = new int[n + 1];
        // System.out.println(fibWithDpArray(n, dp) + " Runs = " + runs);
        // ArrayList<Integer> dpList = new ArrayList<>(n+1);
        // System.out.println(fibWithDpArrayList(n, dpList) + " Runs = " + runs);
    }

    // 1 1 2 3 5 8 13 21

    static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibWithDpArray(int n, int dp[]) {
        runs++;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        // int res = fib(n - 1, dp) + fib(n - 2, dp);
        // dp[n] = res;
        // return res;
        // short hand for the above three lines is below
        return dp[n] = fibWithDpArray(n - 1, dp) + fibWithDpArray(n - 2, dp);
    }

    // static int fibWithDpArrayList(int n, ArrayList<Integer> dp) {
    // runs++;
    // if (n == 0 || n == 1) {
    // return 1;
    // }
    // if (dp.get(n) != 0) {
    // return dp.get(n);
    // }
    // int res = fibWithDpArrayList(n - 1, dp) + fibWithDpArrayList(n - 2, dp);
    // dp.set(n, res);
    // return res;
    // }
}