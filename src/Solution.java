import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> reOccur = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (reOccur.containsKey(arr[i])) {
                reOccur.put(arr[i], reOccur.get(arr[i]) + 1);
            } else {
                reOccur.put(arr[i], 1);
            }
        }
        for (int i : reOccur.keySet()) {
            if (reOccur.keySet().size() == 1) {
                return true;
            }
            for (int j : reOccur.keySet()) {
                if (i != j && reOccur.get(i) == reOccur.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}