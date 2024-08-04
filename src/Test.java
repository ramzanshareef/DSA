import Search.Searching;

public class Test {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 15, 20, 24, 45, 50, 77 };
        System.out.println(Searching.binarySearch(arr, 24, 0, arr.length - 1));
    }
}