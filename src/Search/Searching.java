package Search;

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

    public static int firstOccurence(int arr[], int target, int l, int h) {
        if (l > h)
            return -1;
        int mid = l + (h - l) / 2;
        if (arr[mid] == target && arr[mid - 1] != target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, l, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, h);
        } else {
            return -1;
        }
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
}