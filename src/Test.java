import Arrays.Basics;

public class Test {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
        };
        Basics.print2DArray(arr);
        Basics.print2DArray(Basics.transpose2DArray(arr));
    }
}