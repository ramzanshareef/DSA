public class Bits {
    public static void main(String[] args) {
        // 0 ^ 0 --> 0
        // 1 ^ 1 --> 0
        // 0 ^ 1 --> 1
        // 1 ^ 0 --> 1
        // same numbers XOR --> 0

        // To Access first bit of integer n --> n&1
        // n ^ n --> 0 --> n XOR n =0
        // To add 1 to last of zeroes n(000000) do `n<<1 | 1`
        int[] arr = { 1, 2, 3, 4, 5 };
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
