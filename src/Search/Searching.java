package Search;

import java.util.ArrayList;
import java.util.Arrays;

public class Searching {
    public static int binarySearch(int arr[], int target, int l, int h) {
        if (l > h)
            return -1;
        int mid = l + (h - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, l, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, h);
        } else {
            return -1;
        }
    }

    public static int firstOccurence(int arr[], int target) {
        Arrays.sort(arr);
        int l = 0;
        int h = arr.length - 1;
        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target) {
                res = mid;
                h = mid - 1;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static int lastOccurence(int arr[], int target) {
        Arrays.sort(arr);
        int l = 0;
        int h = arr.length - 1;
        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target) {
                res = mid;
                l = mid + 1;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public static int squareRoot(int x) {
        int i = 0, j = x;
        int ans = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int value = mid * mid;
            if (value == x)
                return mid;
            else if (value < x) {
                i = mid + 1;
                ans = mid;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public static int minInRotatedSortedArray(int arr[]) {
        int n = arr.length, low = 0, high = n - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= arr[n - 1]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findInRotatedSortedArray(int arr[], int x) {
        int n = arr.length, low = 0, high = n - 1, pivot = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= arr[n - 1]) {
                pivot = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (arr[n - 1] < x) {
            low = 0;
            high = pivot - 1;
        } else {
            low = pivot;
            high = n - 1;
        }
        n = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

    public static boolean findInRotatedSortedArrayWithDuplicates(ArrayList<Integer> a, int target) {
        int n = a.size(), low = 0, high = n - 1;
        if (a.get(low) == target) {
            return true;
        }
        while (low <= high && a.get(low) == a.get(high)) {
            low++;
            high--;
        }
        if (low > high) {
            return false;
        }
        int newStart = low, newEnd = high;
        int pivot = newEnd + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) <= a.get(newEnd)) {
                pivot = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (a.get(newEnd) < target) {
            low = newStart;
            high = pivot - 1;
        } else {
            low = pivot;
            high = newEnd;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) == target) {
                return true;
            } else if (a.get(mid) > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return false;
    }
}