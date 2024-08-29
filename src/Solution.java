class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = totalHoursWithSpeekK(piles, mid);
            if (val <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int totalHoursWithSpeekK(int piles[], int k) {
        int res = 0;
        for (int i = 0; i < piles.length; i++) {
            res += Math.ceil((double) piles[i] / (double) k);
        }
        return res;
    }
}