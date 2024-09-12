class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for (String word : words) {
            if (word.contains(allowed)){
                res++;
            }
        }
        return res;
    }
}