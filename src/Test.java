public class Test {
    public static void main(String[] args) {
        var startTime = System.nanoTime();
        var endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
    static boolean isPowerOfTwo(int n) {
        int value = (int)(Math.log(n) / Math.log(2));
        if (value>Integer.MIN_VALUE && value<Integer.MAX_VALUE) return true;
        return false;
    }
}