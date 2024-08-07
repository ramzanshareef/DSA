package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Basics {
    static Scanner input = new Scanner(System.in);

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

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            if (xor == 0) {
                result++;
            } else {
                result = 0;
            }
        }
        return result;
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

    public static ArrayList<Integer> mergeTwoArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result.add(nums1[i++]);
            } else {
                result.add(nums2[j++]);
            }
        }
        while (i < m) {
            result.add(nums1[i++]);
        }
        while (j < n) {
            result.add(nums2[j++]);
        }
        return result;
    }

    public static void reverseElementsInArray(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] + arr[i2];
        arr[i2] = arr[i1] - arr[i2];
        arr[i1] = arr[i1] - arr[i2];
    }

    public static void reverseArray(int[] arr, int i, int j) {
        while (i < j) {
            reverseElementsInArray(arr, i++, j--);
        }
    }

    public static void rotateByKSteps(int[] arr, int k) {
        reverseArray(arr, 0, arr.length - 1 - k);
        reverseArray(arr, arr.length - k, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    public static boolean checkIfArraySortedAndRotated(int[] arr) {
        int gCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                gCount++;
            }
        }
        if (arr[arr.length - 1] > arr[0]) {
            gCount++;
        }
        return gCount <= 1;
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                index++;
            }
        }
        return index + 1;
    }

    public static int searchInSorted(int arr[], int N, int K) {
        for (int i = 0; i < N; i++) {
            if (K == arr[i]) {
                return 1;
            }
        }
        return -1;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            } else {
                freqMap.put(nums[i], 1);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < freqMap.size(); i++) {
            result = Math.max(result, freqMap.get(nums[i]));
        }
        return result;
    }

    public static int[] nonDecreasingSquaresFromArray(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0, j = arr.length - 1, index = arr.length - 1;
        while (i <= j) {
            if (Math.abs(arr[j]) > Math.abs(arr[i])) {
                result[index] = arr[j] * arr[j];
                j--;
            } else {
                result[index] = arr[i] * arr[i];
                i++;
            }
            index--;
        }
        return result;
    }

    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 0, sum = 0;
        long ans = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += 1 + even;
                odd++;
            }
        }
        return (int) (ans % (Math.pow(10, 9) + 7));
    }

    public static void print2DArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] input2DArray() {
        System.out.print("Rows = ");
        int r = input.nextInt();
        System.out.print("Columns = ");
        int c = input.nextInt();
        int arr[][] = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        return arr;
    }

    public static void transposeArrayInPlace(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i < j) {
                    arr[i][j] = arr[i][j] + arr[j][i];
                    arr[j][i] = arr[i][j] - arr[j][i];
                    arr[i][j] = arr[i][j] - arr[j][i];
                }
            }
        }
    }

    public static int[][] transpose2DArray(int arr[][]) {
        int result[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j][i] = arr[i][j];
            }
        }
        return result;
    }

    public void rotate2DArrayBy90Degrees(int[][] matrix) {
        transposeArrayInPlace(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverseArray(matrix[i], 0, matrix[i].length - 1);
        }
    }

    public static void printSpiralMatrix(int[][] matrix, int r, int c) {
        int tr = 0, br = r - 1, lc = 0, rc = c - 1;
        int totalElements = 0;
        System.out.println("Spiral Order Below");
        while (totalElements < r * c) {
            for (int j = lc; j <= rc && totalElements < r * c; j++) {
                System.out.print(matrix[tr][j] + " ");
                totalElements++;
            }
            tr++;
            for (int i = tr; i <= br && totalElements < r * c; i++) {
                System.out.print(matrix[i][rc] + " ");
                totalElements++;
            }
            rc--;
            for (int j = rc; j >= lc && totalElements < r * c; j--) {
                System.out.print(matrix[br][j] + " ");
                totalElements++;
            }
            br--;
            for (int i = br; i >= tr && totalElements < r * c; i--) {
                System.out.print(matrix[i][lc] + " ");
                totalElements++;
            }
            lc++;
        }
    }

    public static int[][] fillInSpiralOrder(int n) {
        int[][] spiralMatrix = new int[n][n];
        int tr = 0, br = n - 1, lc = 0, rc = n - 1;
        int value = 1;
        while (value <= n * n) {
            for (int j = lc; j <= rc && value <= n * n; j++) {
                spiralMatrix[tr][j] = value++;
            }
            tr++;
            for (int i = tr; i <= br && value <= n * n; i++) {
                spiralMatrix[i][rc] = value++;
            }
            rc--;
            for (int j = rc; j >= lc && value <= n * n; j--) {
                spiralMatrix[br][j] = value++;
            }
            br--;
            for (int i = br; i >= tr && value <= n * n; i--) {
                spiralMatrix[i][lc] = value++;
            }
            lc++;
        }
        return spiralMatrix;
    }

    public static int areaWithCoOrdinatesIn2DArray(int[][] matrix, int l1, int r1, int l2, int r2) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) { // Prefix sum over a row
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = l1; i <= l2; i++) {
            if (r1 >= 1) {
                result += matrix[i][r2] - matrix[i][r1 - 1];
            } else {
                result += matrix[i][r2];
            }
        }
        return result;
    }

    public static int areaWithCoOrdinatesIn2DArrayWithColRowPrefix(int[][] matrix, int l1, int r1, int l2, int r2) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        print2DArray(matrix);
        int left = 0, up = 0, leftup = 0;
        if (l1 >= 1)
            up = matrix[l1 - 1][r2];
        if (r1 >= 1)
            left = matrix[l2][r1 - 1];
        if (l1 >= 1 && r1 >= 1)
            leftup = matrix[l1 - 1][r1 - 1];
        int ans = matrix[l2][r2] - left - up + leftup;
        return ans;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefMul = new int[nums.length];
        int[] suffMul = new int[nums.length];
        int[] result = new int[nums.length];
        prefMul[0] = 1;
        suffMul[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefMul[i] = nums[i - 1] * prefMul[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffMul[i] = nums[i + 1] * suffMul[i + 1];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = prefMul[i] * suffMul[i];
        }
        return result;
    }

    public static int secondLargest(int nums[]) {
        int largest = nums[0];
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == largest)
                continue;
            else if (nums[i] > largest) {
                res = largest;
                largest = nums[i];
            }
        }
        return res;
    }
}