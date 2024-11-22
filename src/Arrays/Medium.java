package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static int majorityElement(int arr[]) {
        // return an element which appears more than n/2 times, where n = length of the
        // array

        // Approach 1 -> Hashing the count of the numbers and then checking
        // int res = -1;
        // Map<Integer, Integer> cacheMap = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        // cacheMap.put(arr[i], cacheMap.getOrDefault(arr[i], 0) + 1);
        // }
        // for (Map.Entry<Integer, Integer> entry : cacheMap.entrySet()) {
        // if (entry.getValue() > arr.length / 2) {
        // res = entry.getKey();
        // break;
        // }
        // }
        // return res;

        int candidate = -1;
        int votes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (votes == 0) {
                candidate = arr[i];
            } else if (arr[i] == candidate)
                votes++;
            else
                votes--;
        }
        int actualVotes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate)
                actualVotes++;
        }
        if (actualVotes > arr.length / 2) {
            return candidate;
        }
        return -1;
    }

    public static ArrayList<Integer> findMaxSumSubArray(int arr[]) {
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        int start = 0;
        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                startIndex = start;
                endIndex = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            res.add(arr[i]);
        }
        System.out.println("Maxium Sub-Array Sum = " + maxi);
        return res;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minCost = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - minCost;
            profit = Math.max(profit, cost);
            minCost = Math.min(minCost, prices[i]);
        }
        return profit;
    }

    public static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n - 1];
        ans.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        ans = new ArrayList<Integer>(ans.reversed());
        return ans;
    }

    public static List<Integer> generateNthRowOfPascalTriangle(int r) {
        long ans = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int col = 1; col < r; col++) {
            ans = ans * (r - col);
            ans = ans / col;
            row.add((int) ans);
        }
        return row;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            ans.add(generateNthRowOfPascalTriangle(row));
        }
        return ans;
    }

}