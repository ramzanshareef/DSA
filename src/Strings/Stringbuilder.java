package Strings;

public class Stringbuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("ramzan");
        System.out.println(str);
        str.insert(3, 'o');
        System.out.println(str);
    }
}
