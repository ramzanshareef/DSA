import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int requiredPairs = arr.length / 2;
        int pairs = 0;
        for (int ele : arr) {
            int rem = ele % k;
            if (rem != 0) {
                pairs += map.get(k - rem);
            } else {
                pairs += map.get(0);
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return pairs == requiredPairs;
    }
}