class Solution {
    public int maxProduct(int[] nums) {
        double prefProd = 1;
        double suffProd = 1;
        double res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            suffProd = suffProd == 0 ? 1 : suffProd;
            prefProd = prefProd == 0 ? 1 : prefProd;
            prefProd *= nums[i];
            suffProd *= nums[nums.length-1-i];
            res = Math.max(res, Math.max(suffProd, prefProd));
        }
        return (int) res;
    }
}