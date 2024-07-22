package Recursion;
public class Basics {
    public static void main(String[] args) {
        printKMultiples(3, 7);
    }

    public static void printNTo1(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printNTo1(n - 1);
        System.out.print(n + " ");
    }

    public static int factorialOfNumber(int n) {
        if (n == 1)
            return 1;
        return n * factorialOfNumber(n - 1);
    }

    public static int nThFibinaccoNumber(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1)
            return 0;
        return nThFibinaccoNumber(n - 1) + nThFibinaccoNumber(n - 2);
    }

    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    public static int countOfDigits(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + countOfDigits(n / 10);
    }

    public static int pPowerQ(int p, int q) {
        if (q == 0)
            return 1;
        else if (q == 1)
            return p;
        return p * pPowerQ(p, q - 1);
    }

    public static int pPowerQBetterTimeComplexity(int p, int q) {
        if (q == 0)
            return 1;
        int midPow = pPowerQBetterTimeComplexity(p, q / 2);
        if (q % 2 == 0) {
            return midPow * midPow;
        }
        return p * midPow * midPow;
    }

    public static void printKMultiples(int n, int k) {
        if (k == 0)
            return;
        printKMultiples(n, k - 1);
        System.out.print(n * k + " ");
    }

    public static int gcdUsingEuclid(int x, int y) {
        if (y == 0)
            return x;
        return gcdUsingEuclid(y, x % y);
    }
}
