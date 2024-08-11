package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Medium {
    public static int getLongestSubArrayWithSumK(int arr[], long k) {
        Map<Long, Integer> cacheMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long remSum = sum - k;
            if (cacheMap.containsKey(remSum)) {
                int len = i - cacheMap.get(remSum);
                maxLen = Math.max(maxLen, len);
            }
            if (!cacheMap.containsKey(sum)) {
                cacheMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int maxLengthSubArrayWithSumK(int arr[], long k) {
        int l = 0, r = 0, sum = arr[0];
        int res = 0;
        while (r < arr.length) {
            while (l <= r && sum > k) {
                sum -= arr[l++];
            }
            if (sum == k) {
                res = Math.max(res, r - l + 1);
            }
            r++;
            if (r < arr.length) {
                sum += arr[r];
            }
        }
        return res;
    }
}