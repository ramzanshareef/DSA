import java.util.HashMap;

class Solution {
    // public static String[] sortPeople(String[] names, int[] heights) {

    // }

    public static void main(String[] args) {
        String[] names = { "Mary", "John", "Emma" };
        int[] heights = { 180, 165, 170 };
        HashMap<String, Integer> people = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            people.put(names[i], heights[i]);
        }
    }
}