import java.util.*;

public class Example {
    static boolean solve(int n, String s, String t) {
        boolean res = false;
        if (s.length() != t.length()) {
            return res;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        if (sMap.equals(tMap)) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }
}

abstract class Solution1 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

abstract class Solution2 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        
        int[] increasingLengths = new int[n];
        increasingLengths[n - 1] = 1;
        
        // Calculate the length of the longest increasing subarray starting at each index
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                increasingLengths[i] = increasingLengths[i + 1] + 1;
            } else {
                increasingLengths[i] = 1;
            }
        }

        // Binary search for the maximum k
        int left = 1, right = n / 2, maxK = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canFindAdjacentIncreasingSubarrays(increasingLengths, mid)) {
                maxK = mid; // Found a valid k, try to find a larger k
                left = mid + 1;
            } else {
                right = mid - 1; // Try a smaller k
            }
        }
        
        return maxK;
    }

    private boolean canFindAdjacentIncreasingSubarrays(int[] increasingLengths, int k) {
        for (int i = 0; i <= increasingLengths.length - 2 * k; i++) {
            if (increasingLengths[i] >= k && increasingLengths[i + k] >= k) {
                return true;
            }
        }
        return false;
    }
}