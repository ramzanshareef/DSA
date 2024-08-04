package Sorting;

public class Sorts {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    public static void optimizedBubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    swapped = true;
                }
                if (!swapped)
                    return;
            }
        }
    }

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void recursiveInsertionSort(int arr[], int n) {
        if (n <= 1)
            return;
        recursiveInsertionSort(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void mergeSort(int arr[], int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
        for (i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end)
            return;
        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int partition(int[] arr, int st, int end) {
        int pivot = arr[st];
        int cnt = 0;
        for (int i = st + 1; i <= end; i++) {
            if (arr[i] <= pivot)
                cnt++;
        }
        int pivotIdx = st + cnt;
        swap(arr, st, pivotIdx);
        int i = st, j = end;
        while (i < pivotIdx && j > pivotIdx) {
            while (arr[i] <= pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i < pivotIdx && j > pivotIdx) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIdx;
    }

    public static int findMax(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    public static void basicCountSort(int[] arr) {
        int max = findMax(arr);
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }
    }

    static void countSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int max = findMax(arr);
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = count[arr[i]] - 1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}