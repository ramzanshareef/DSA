import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(3);
        list.add(5);
        list.add(22);
        list.add(10);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Welcome");
        strings.add("to");
        strings.add("DSA");
        strings.add("Ramzan");
        System.out.println(strings);
        Collections.sort(strings, Collections.reverseOrder());
        System.out.println(strings);
    }
}