package Arrays;

import java.util.List;

public class Subsets {
    public static void printAllSubSequencesSum(int[] arr, int currIndex, int currSum) {
        if (currIndex == arr.length) {
            System.out.println(currSum);
            return;
        }
        printAllSubSequencesSum(arr, currIndex + 1, currSum + arr[currIndex]);
        printAllSubSequencesSum(arr, currIndex + 1, currSum);
    }
}
