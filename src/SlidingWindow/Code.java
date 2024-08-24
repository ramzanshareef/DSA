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

    public static int getLengthofLongestSubstring(int k, String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.size() > k) {
                if (map.get(s.charAt(left)) == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int numberOfSubstrings(String s) {
        int[] map = new int[] { -1, -1, -1 };
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
            if (map[0] != -1 && map[1] != -1 && map[2] != -1)
                res += 1 + Math.min(map[0], Math.min(map[1], map[2]));
        }
        return res;
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] hash = new int[26];
        int left = 0, right = 0, maxFreq = 0, res = 0;
        while (right < len) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            if ((right - left + 1) - maxFreq <= k) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }

    public static int countSubArraysWithSumKInBinaryArray(int arr[], int k) {
        return countSubArraysWithSumLessThanKInBinaryArray(arr, k)
                - countSubArraysWithSumLessThanKInBinaryArray(arr, k - 1);
    }

    public static int countSubArraysWithSumLessThanKInBinaryArray(int arr[], int k) {
        if (k < 0) {
            return 0;
        }
        int left = 0, right = 0, res = 0, sum = 0;
        while (right < arr.length) {
            sum += arr[right];
            if (sum > k) {
                sum -= arr[right];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysWithMaxKOddNumbers(nums, k) - numberOfSubarraysWithMaxKOddNumbers(nums, k - 1);
    }

    public int numberOfSubarraysWithMaxKOddNumbers(int arr[], int k) {
        if (k < 0) {
            return 0;
        }
        int res = 0, left = 0, right = 0, oddNumbers = 0;
        while (right < arr.length) {
            if (arr[right] % 2 != 0) {
                oddNumbers++;
            }
            while (oddNumbers > k) {
                if (arr[left] % 2 != 0) {
                    oddNumbers--;
                }
                left++;
            }
            if (oddNumbers <= k) {
                res += right - left;
            }
            right++;
        }
        return res;
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}