package Arrays;

/**
 * Basics
 */
public class Basics {
    public static void main(String[] args) {
        // System.out.println(object) --> this will call the .toString() from the object
        // and for built-in arrays it gives the memory address of the first element
        int arr[] = { 1, 1, 3, 4, 2, 3, 5, 7, 0 };
        print1DArray(arr);
        System.out.println(firstPeekElement(arr));
    }

    public static void print1DArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i == arr.length - 1) {
                System.out.println();
            }
        }
    }

    public static int firstPeekElement(int arr[]) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int firstRepeatedElement(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] ^ arr[j]) == 0) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static String pairWithAbsDiffExists(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == target) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    // Given an array arr[] of size N-1 with integers in the range of [1, N], the
    // task is to find the missing number from the first N integers. There are no
    // duplicates in the list.
    public static int missingNumber(int arr[], int n) {
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }


}