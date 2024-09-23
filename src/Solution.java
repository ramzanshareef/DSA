import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }
        HashMap<Integer, Integer> memo = new HashMap<>();
        return minExtra(s, 0, dict, memo);
    }

    private int minExtra(String s, int start, Set<String> dict, HashMap<Integer, Integer> memo) {
        if (start == s.length()) {
            return 0;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int minExtraChars = 1 + minExtra(s, start + 1, dict, memo);
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (dict.contains(substring)) {
                minExtraChars = Math.min(minExtraChars, minExtra(s, end, dict, memo));
            }
        }
        memo.put(start, minExtraChars);
        return minExtraChars;
    }
}