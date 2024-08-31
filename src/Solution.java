import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int arr[] = {10, 20, 0, -5, 6, 180};
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}