public class Bits {
    public static void main(String[] args) {
        // 0 ^ 0 --> 0
        // 0 ^ 1 --> 1
        // 1 ^ 1 --> 0
        // 1 ^ 0 --> 1
        // 0 ^ n --> n
        // same numbers XOR --> 0

        // To Access first bit of integer n --> n&1
        // n ^ n --> 0 --> n XOR n =0
        // To add 1 to last of zeroes n(000000) do `n<<1 | 1`

        int dec = 20;
        Convertor convertor = new Convertor();
        System.out.println(convertor.decToBinary(dec));
        System.out.println(convertor.binaryToDecimal(10100));
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
}