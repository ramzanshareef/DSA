class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] prefMul = new int[nums.length];
        int[] suffMul = new int[nums.length];
        int[] result = new int[nums.length];
        prefMul[0] = 1;
        suffMul[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefMul[i] = nums[i - 1] * prefMul[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffMul[i] = nums[i + 1] * suffMul[i + 1];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = prefMul[i] * suffMul[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { -1, 1, 0, -3, 3 };
        productExceptSelf(nums);
    }
}