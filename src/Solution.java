class Solution {
    public long validSubstringCount(String primary, String pattern) {
        int[] targetCount = new int[26];
        for (char c : pattern.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int[] windowCount = new int[26];
        int start = 0;
        int neededChars = pattern.length();
        long res = 0;
        for (int end = 0; end < primary.length(); end++) {
            char curr = primary.charAt(end);
            if (targetCount[curr - 'a'] > 0) {
                if (windowCount[curr - 'a'] < targetCount[curr - 'a']) {
                    neededChars--;
                }
            }
            windowCount[curr - 'a']++;
            while (neededChars == 0) {
                res += primary.length() - end;
                char startChar = primary.charAt(start);
                windowCount[startChar - 'a']--;
                if (targetCount[startChar - 'a'] > 0 && windowCount[startChar - 'a'] < targetCount[startChar] - 'a') {
                    neededChars++;
                }
                start++;
            }
        }
        return res;
    }
}