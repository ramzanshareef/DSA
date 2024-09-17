import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : str1) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        for (String string : str2) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        ArrayList<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                resList.add(entry.getKey());
            }
        }
        return resList.toArray(new String[0]);
    }
}
