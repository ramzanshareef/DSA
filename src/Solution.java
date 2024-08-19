class Solution {
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i * i <= n;) {
            if (n % i == 0) {
                res += i;
                n = n / i;
            } else {
                i++;
            }
        }
        if (n != 1) {
            res = res + n;
        }
        return res;
    }
}