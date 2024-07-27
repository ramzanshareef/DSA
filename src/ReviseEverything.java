import java.util.Scanner;

public class ReviseEverything {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
        int freqArr[] = new int[dep.length - arr.length];
        freqArr[0] = Math.min(arr[0], dep[0]);
        freqArr[freqArr.length] = Math.max(arr[arr.length - 1], dep[dep.length - 1]);

    }
}