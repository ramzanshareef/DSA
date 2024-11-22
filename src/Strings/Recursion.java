package Strings;

import java.util.ArrayList;

public class Recursion {
    public static String removeAllOccurenesOfaInString(String s) {
        if (s.length() == 0) {
            return "";
        }
        Character smallAns = s.charAt(0);
        if (smallAns == 'a') {
            return removeAllOccurenesOfaInString(s.substring(1));
        }
        return smallAns + removeAllOccurenesOfaInString(s.substring(1));
    }

    public static String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        Character smallAns = s.charAt(s.length() - 1);
        return smallAns + reverseString(s.substring(0, s.length() - 1));
    }

    public static boolean isPalindromeString(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return (s.charAt(0) == s.charAt(s.length() - 1)) && isPalindromeString(s.substring(1, s.length() - 1));
    }

    public static String mergeStrings(String s1, String s2) {
        String result = "";
        if (s1.length() == 0) {
            result += s2;
            return result;
        }
        if (s2.length() == 0) {
            result += s1;
            return result;
        }
        result += s1.substring(0, 1);
        result += s2.substring(0, 1);
        result += mergeStrings(s1.substring(1), s2.substring(1));
        return result;
    }

    public static ArrayList<String> getAllSubSequences(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.length() <= 1) {
            result.add(s);
            result.add("");
            return result;
        }
        ArrayList<String> smallWorkAns = getAllSubSequences(s.substring(1));
        for (int i = 0; i < smallWorkAns.size(); i++) {
            result.add(smallWorkAns.get(i));
            result.add(s.charAt(0) + smallWorkAns.get(i));
        }
        return result;
    }

    public static void printAllSubSequences(String s, String currAns) {
        if (s.length() == 0) {
            System.out.println(currAns);
            return;
        }
        printAllSubSequences(s.substring(1), currAns + s.charAt(0));
        printAllSubSequences(s.substring(1), currAns);
    }

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