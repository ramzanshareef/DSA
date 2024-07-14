package spaceTimeComplexity;

import java.util.Arrays;

public class Linear {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
        // in our Constant space complexity the notation was O(1)
        arr[0] = arr[0] + 10; // System Complexity -> O(1)
        System.out.println("arr[0] : " + arr[0]); // Time Complexity -> O(1) System Complexity -> O(1)
        
        // Print elements of the array
        for (int j : arr) {
            System.out.println(j); // O(n) -> Time Complexity cuz it take time to print n no. of array element
        }
        // But its Space complexity is O(1) cuz here we are not defining any new
        // variable which will take input

        int[] newArray = new int[arr.length];// Space complexity -> O(n)
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i]; // Time C. -> O(n) Space C. -> O(1)
        }
        System.out.println("newArray = " + Arrays.toString(newArray));

        // overAll Complexity
        // Space Complexity = O(n)
        // Time Complexity = O(n)

    }
}