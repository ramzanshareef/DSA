import Arrays.Basics;

public class Test {
    public static void main(String[] args) {
        int arr[] = { -10, -3, -2, 1, 4, 5 };
        Basics.print1DArray(arr);
        Basics.print1DArray(Basics.nonDecreasingSquaresFromArray(arr));
    }
}