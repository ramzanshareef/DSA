import java.util.ArrayList;

import ArrayLists.Basics;

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
        Basics.reverseArrayList(list);
    }
}