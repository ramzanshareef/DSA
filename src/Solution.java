import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int count = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}