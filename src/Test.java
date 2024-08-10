import java.util.Arrays;
import Arrays.Basics;

public class Test {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 7, 7, 1 };
        // System.out.println(Searching.minInRotatedSortedArray(arr));
        System.out.println(Basics.secondSmallest(arr));
        System.out.println(Basics.secondLargest(arr));
        Arrays.sort(arr);
        Basics.print1DArray(arr);
    }
}