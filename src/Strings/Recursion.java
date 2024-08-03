package Strings;

import java.util.ArrayList;

public class Recursion {
    public static void keyboardToNumbercombination(String s, ArrayList<String> v, ArrayList<String> ans, int idx, String res) {
        if (idx >= s.length()) {
            ans.add(res);
            return;
        }
        int digit = s.charAt(idx) - '0';
        if (digit <= 1)
            keyboardToNumbercombination(s, v, ans, idx + 1, res);
        for (int j = 0; j < v.get(digit).length(); j++) {
            keyboardToNumbercombination(s, v, ans, idx + 1, res + v.get(digit).charAt(j));
        }
    }
}