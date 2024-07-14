import java.util.HashMap;
import java.util.Map;

class HashMapBasic {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(target - nums[i])) {
                System.gc();
                return new int[] { myMap.get(target - nums[i]), i };
            } else {
                myMap.put(nums[i], i);
            }
        }
        System.gc();
        return new int[] { -1, -1 };
    }
}