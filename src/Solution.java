class Solution {
    public int nextGreaterElement(int n) {
        String s = Integer.toString(n);
        int arr[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i - 1 < 0)
            return -1;
        int j = arr.length - 1;
        while (j > (i - 1) && arr[j] <= arr[i - 1]) {
            j--;
        }
        swap(arr, i - 1, j);
        reverse(arr, i);
        int ans = 0;
        for (i = 0; i < arr.length; i++) {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && arr[i] > 7))
                return -1;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && arr[i] < -8))
                return -1;
            ans = ans * 10 + arr[i];
        }
        return ans == n ? -1 : ans;
    }

    private void reverse(int[] arr, int i) {
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}