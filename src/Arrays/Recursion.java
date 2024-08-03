package Arrays;

public class Recursion {
    public static void print1DArrayRec(int[] arr, int i) {
        if (i == arr.length)
            return;
        System.out.print(arr[i] + " ");
        print1DArrayRec(arr, ++i);
    }

    public static int maximumValueFromArrayRec(int[] arr, int i) {
        if (arr.length == 0)
            return -1;
        if (i == arr.length - 1) {
            return arr[i];
        }
        return Math.max(arr[i], maximumValueFromArrayRec(arr, ++i));
    }

    public static int sumOfElementsInArray(int[] arr, int i) {
        if (i == arr.length) {
            return 0;
        }
        return arr[i] + sumOfElementsInArray(arr, i + 1);
    }

    public static void linearSearchInArray(int[] arr, int target, int i) {
        if (i >= arr.length)
            return;
        if (arr[i] == target) {
            System.out.print(i + " ");
        }
        linearSearchInArray(arr, target, i + 1);
    }

    public static int frogMinCostToJumpToLast(int[] heights, int n, int i) {
        if (i == n - 1) {
            return 0;
        }
        int opt1 = frogMinCostToJumpToLast(heights, n, i + 1) + Math.abs(heights[i + 1] - heights[i]);
        if (i == n - 2) {
            return opt1;
        }
        int opt2 = frogMinCostToJumpToLast(heights, n, i + 2) + Math.abs(heights[i + 2] - heights[i]);
        return Math.min(opt1, opt2);
    }

}