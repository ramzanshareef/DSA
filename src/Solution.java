import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int l = 0;
            int r = 0;
            int count = 0;
            while (r < nums.length) {
                if (nums[r] - nums[l] > mid) {
                    l++;
                } else {
                    count += r - l;
                    r++;
                }
            }
            if (count >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}