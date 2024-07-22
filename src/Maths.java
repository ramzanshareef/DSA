import Recursion.Basics;

public class Maths {
    public static void main(String[] args) {
        System.out.println(gcdOfTwoNumber(15, 24));
        System.out.println(Basics.gcdUsingEuclid(24, 15));
    }

    public static int gcdOfTwoNumber(int x, int y) {
        while (x % y != 0) {
            int rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }
}
