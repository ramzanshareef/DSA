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
        if (arr[mid] == target && arr[mid-1]!=target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, l, mid - 1);
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, h);
        } else {
            return -1;
        }
    }
}
