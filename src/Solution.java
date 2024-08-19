import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count = 0;
        int firstEle = Integer.MIN_VALUE;
        int secEle = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && secEle != nums[i]) {
                count1 = 1;
                firstEle = nums[i];
            } else if (count == 0 && firstEle != nums[i]) {
                count = 1;
                secEle = nums[i];
            } else if (nums[i] == firstEle) {
                count1++;
            } else if (nums[i] == secEle) {
                count++;
            } else {
                count1--;
                count--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == firstEle)
                count1++;
            if (nums[i] == secEle)
                count++;
        }

        int minLength = (int) (n / 3) + 1;
        if (count1 >= minLength)
            res.add(firstEle);
        if (count >= minLength)
            res.add(secEle);
        return res;
    }
}