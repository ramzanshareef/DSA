class Solution {
    public boolean lemonadeChange(int[] bills) {
        int numberOfFives = 0, numberOfTens = 0;
        for (int i : bills) {
            if (i == 5) { // 5$
                numberOfFives++;
            } else if (i == 10) { // 10$
                numberOfFives--;
                numberOfTens++;
            } else if (numberOfTens > 0 && numberOfFives >= 1) { // 20$
                numberOfTens--;
                numberOfFives--;
            } else {
                numberOfFives -= 3;
            }
            if (numberOfFives < 0) {
                return false;
            }
        }
        return true;
    }
}