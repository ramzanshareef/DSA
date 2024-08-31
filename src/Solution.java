public class Solution {
    public static String compressString(String s) {
        StringBuilder res = new StringBuilder();
        int currCount = 1;
        char currChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char prevChar = s.charAt(i - 1);
            currChar = s.charAt(i);
            if (prevChar == currChar) {
                currCount++;
                if (currCount == 10) {
                    res.append(9).append(prevChar);
                    currCount = 1;
                }
            } else {
                res.append(currCount).append(prevChar);
                currCount = 1;
            }
        }
        res.append(currCount).append(currChar);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaabb";
        System.out.println(compressString(s));
    }
}