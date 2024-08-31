package OOPs;

public class Basics {
    public static class StudentClass {
        String name;
        int rollNo;
    }

    private static void change(StudentClass obj){
        obj.name = "HACKED";
        System.out.println(obj.rollNo);
    }
    public static void main(String[] args) {
        StudentClass s1 = new StudentClass();
        s1.name = "ramzan";
        s1.rollNo = 120;
        System.out.println(s1.name);
        change(s1);
        System.out.println(s1.name);
    }
}