import java.util.List;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = Integer.MIN_VALUE;
        int currMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int currMin = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.abs(arrays.get(i).get(0) - currMax));
            res = Math.max(res, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - currMin));
            currMax = Math.max(currMax, arrays.get(i).get(arrays.get(i).size() - 1));
            currMin = Math.min(currMin, arrays.get(i).get(0));
        }
        return res;
    }
}