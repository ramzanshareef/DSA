import Search.Searching;

public class Test {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -1, 4, -1, 2, -1, -5, 4 };
        System.out.println(Searching.lastOccurence(arr, -1, 0, arr.length));
    }
}