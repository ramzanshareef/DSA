public class Base {
    public int add(int a, int b) {
        if (a==0) {
            return b;
        } else {
            return add(a-1, b+1);
        }
    }
}