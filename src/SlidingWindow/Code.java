package SlidingWindow;

public class Code {
    public static int maxSumWithKSizeSubArray(int arr[], int k) {
        int res = 0;
        int l = 0;
        int h = k - 1;
        for (int i = l; i <= h; i++) {
            res += arr[i];
        }
        int sum = res;
        while (h < arr.length - 1) {
            sum -= arr[l];
            l++;
            h++;
            sum += arr[h];
            res = Math.max(res, sum);
        }
        return res;
    }

    public static int longestSubArrayWithSumLessThanEqualToK(int arr[], int k) {
        int res = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum <= k) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }
}
