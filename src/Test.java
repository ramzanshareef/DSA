import Arrays.*;

public class Test {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        long k = 6;
        int len = Medium.maxLengthSubArrayWithSumK(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
}