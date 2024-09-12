import Stacks.Expressions;

public class Test {
    public static void main(String[] args) {
        String str = "8-5+3*4/6";
        System.out.println(Expressions.infixEval(str));
    }
}