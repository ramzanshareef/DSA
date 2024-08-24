package SlidingWindow;

import java.util.HashMap;

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
            // if (sum > k) {
            // sum -= arr[left];
            // left++;
            // }
            if (sum <= k) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }

    public static int maxScore(int[] arr, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int res = 0;
        for (int i = 0; i <= k - 1; i++) {
            leftSum += arr[i];
            res = Math.max(res, leftSum);
        }
        int rightIndex = arr.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= arr[i];
            rightSum += arr[rightIndex--];
            res = Math.max(res, leftSum + rightSum);
        }
        return res;
    }

    public static int longestSubArrayWithKZereos(int arr[], int k) {
        int left = 0;
        int right = 0;
        int zereos = 0;
        int res = 0;
        while (right < arr.length) {
            if (arr[right] == 0) {
                zereos++;
            }
            if (zereos > k) {
                if (arr[left] == 0) {
                    zereos--;
                }
                left++;
            }
            if (zereos <= k) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }

    public static int totalFruit(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int res = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            if (map.size() > 2) {
                if (map.get(arr[left]) == 1) {
                    map.remove(arr[left]);
                } else {
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
