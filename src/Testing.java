import java.util.*;

public class Testing {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(10, 20, 30));
        res.addAll(list);
        System.out.println(res);
    }
}