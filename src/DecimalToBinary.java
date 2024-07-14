import java.util.Scanner;

public class DecimalToBinary {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a Number = ");
        int n = input.nextInt();
        System.out.println(DecToBin(n));
    }

    static String DecToBin(int dec) {
        String res = "";
        while (dec > 0) {
            int rem = dec % 2;
            dec /= 2;
            res = rem + res;
        }
        return res;
    }
}
