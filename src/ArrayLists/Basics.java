package ArrayLists;
import java.util.ArrayList;

public class Basics {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        System.out.println(l1);
        l1.add(2, 500);
        System.out.println(l1);
        l1.remove(4);
        System.out.println(l1);
        l1.remove(Integer.valueOf(20));
        System.out.println(l1);
        l1.contains(Integer.valueOf(50));
    }

    public static void reverseArrayList(ArrayList<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i<j) {
            Integer temp = Integer.valueOf(list.get(i));
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
        System.out.println(list);
    }
}
