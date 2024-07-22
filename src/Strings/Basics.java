package Strings;

public class Basics {
    public static void main(String[] args) {
        String name = "Ramzan Shareef";
        System.out.print(name.substring(2, 5));
    }

    public static String removeAllOccurenesOfaInString(String s) {
        if (s.length()==0){
            return "";
        }
        Character smallAns = s.charAt(0);
        if (smallAns == 'a') {
            return removeAllOccurenesOfaInString(s.substring(1));
        }
        return smallAns + removeAllOccurenesOfaInString(s.substring(1));
    }
}
