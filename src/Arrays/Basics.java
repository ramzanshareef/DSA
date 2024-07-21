package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, result[] = new int[nums1.length];
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }
        while (i < m) {
            result[index++] = nums1[i++];
        }
        while (j < n) {
            result[index++] = nums2[j++];
        }
        nums1 = result;
    }

    public static void reverseElementsInArray(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] + arr[i2];
        arr[i2] = arr[i1] - arr[i2];
        arr[i1] = arr[i1] - arr[i2];
    }

    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            reverseElementsInArray(arr, i, arr.length - 1 - i);
        }
    }
}