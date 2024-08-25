import java.util.ArrayList;
import java.util.List;

public class Bits {
    // 0 ^ 0 --> 0
    // 0 ^ 1 --> 1
    // 1 ^ 1 --> 0
    // 1 ^ 0 --> 1
    // 0 ^ n --> n
    // same numbers XOR --> 0

    // To Access first bit of integer n --> n&1
    // n ^ n --> 0 --> n XOR n = 0
    // To add 1 to last of zeroes n(000000) do `n<<1 | 1`

    // 1s compliment of 1011 is 0100 that is flip the 1 and 0
    // 2s compliment of a number is its 1s compliment +1

    public static void main(String[] args) {

        int dec = 67;
        Convertor convertor = new Convertor();
        // System.out.println(convertor.decToBinary(dec));
        // System.out.println(convertor.binaryToDecimal(10100));
        convertor.clearRightMostSetBit(dec);
    }
}

class Convertor {
    String decToBinary(int dec) { // Decimal To Binary using bits
        String res = "";
        while (dec > 0) {
            res = (dec & 1) + res;
            dec >>= 1;
        }
        return res;
    }

    int binaryToDecimal(int binary) {
        int res = 0;
        int i = 0;
        while (binary != 0) {
            if (binary % 10 == 1) {
                res += (int) Math.pow(2, i);
            }
            i++;
            binary /= 10;
        }
        return res;
    }

    int bitwiseComplement(int n) {
        if (n == 0)
            return 1;
        int num = n;
        int mask = 0;
        while (num != 0) { // generating a mask
            mask = mask << 1 | 1; // left shifting the bits created in the mask
            num >>= 1; // right shifting the bits in the number
        }
        return (~n) & mask;
    }

    void getIthBit(int n, int i) {
        System.out.println(decToBinary(n));
        String res;
        if ((n & (1 << i)) == 0) {
            res = "0";
        } else {
            res = "1";
        }
        System.out.println("Bit " + i + " = " + res);
    }

    void setIthBit(int n, int i) {
        System.out.println(decToBinary(n));
        n |= (1 << i);
        System.out.println(decToBinary(n));
    }

    void clearIthBit(int n, int i) {
        System.out.println(decToBinary(n));
        n &= ~(1 << i);
        System.out.println(decToBinary(n));
    }

    void toggleIthBit(int n, int i) {
        System.out.println(decToBinary(n));
        n ^= (1 << i);
        System.out.println(decToBinary(n));
    }

    void clearRightMostSetBit(int n) {
        System.out.println(decToBinary(n));
        n &= n - 1;
        System.out.println(decToBinary(n));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int subsets = (1 << nums.length);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}