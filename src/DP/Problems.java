package DP;

public class Problems {
    public int rob(int[] nums) { // LeetCode - 198
        int dp[] = new int[nums.length + 1];
        return solve(nums, 0, dp);
    }

    public int solve(int houses[], int ind, int dp[]) {
        if (ind == houses.length - 1) {
            return houses[ind];
        }
        if (ind >= houses.length) {
            return 0;
        }
        if (dp[ind] != 0) {
            return dp[ind];
        }
        int pickedCurr = houses[ind] + solve(houses, ind + 2, dp);
        int notPickedCurr = solve(houses, ind + 1, dp);
        return dp[ind] = Math.max(pickedCurr, notPickedCurr);
    }

    
}