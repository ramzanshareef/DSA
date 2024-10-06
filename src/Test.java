import java.util.*;

public class Test {
    public static void main(String[] args) {
        char charToRemove = 'a';
        String str = "abdgf";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);
        map.remove(charToRemove, 1);
        System.out.println(map);
    }
}