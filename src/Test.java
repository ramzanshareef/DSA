import Arrays.Basics;

public class Test {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 1, 1, 1 }
        };
        System.out.println(Basics.areaWithCoOrdinatesIn2DArrayWithColRowPrefix(arr, 1, 1, 2, 2));
    }
}