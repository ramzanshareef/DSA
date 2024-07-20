import java.util.Scanner;

public class DecimalToBinary {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a Number = ");
        int n = input.nextInt();
        var beforeTime = System.currentTimeMillis(); // to get the current time
        System.out.println(DecToBin(n));
        var afterTime = System.currentTimeMillis();
        System.out.println("Time Taken = " + (afterTime - beforeTime));
        // to calculate the time taken explicitely for piece of code
    }

    static String DecToBin(int dec) {
        String res = "";
        while (dec > 0) {
            int rem = dec % 2;
            dec /= 2;
            res += rem;
        }
        return res;
    }
}
