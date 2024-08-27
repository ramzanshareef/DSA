class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            int[] freq = new int[26];
            int l = 0, r = 0;
            int uniqueCount = 0;
            int countAtLeastK = 0;
            while (r < n) {
                if (uniqueCount <= uniqueTarget) {
                    int index = s.charAt(r) - 'a';
                    if (freq[index] == 0)
                        uniqueCount++;
                    freq[index]++;
                    if (freq[index] == k)
                        countAtLeastK++;
                    r++;
                }
                while (uniqueCount > uniqueTarget) {
                    int index = s.charAt(l) - 'a';
                    if (freq[index] == k)
                        countAtLeastK--;
                    freq[index]--;
                    if (freq[index] == 0)
                        uniqueCount--;
                    l++;
                }
                if (uniqueCount == uniqueTarget && uniqueCount == countAtLeastK) {
                    res = Math.max(res, r - l);
                }
            }
        }
        return res;
    }
}