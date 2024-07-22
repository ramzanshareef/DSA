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
}
