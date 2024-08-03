import Sorting.*;

public class Test {
    public static void main(String[] args) {
        String[] fruits = { "kiwi", "apple", "papaya", "mango" };
        Problems.sortFruitsLexicographically(fruits);
        for (String val : fruits) {
            System.out.print(val + " ");
        }
    }
}