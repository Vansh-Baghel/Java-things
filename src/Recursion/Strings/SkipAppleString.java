package Recursion.Strings;

public class SkipAppleString {
    public static void main(String[] args) {
        skipApple("" , "akfdappleck");
    }

    static void skipApple(String p, String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (up.startsWith("apple")){
//          If it is equal , then skip the 5 chars of apple and get the further chars from index number 5.
            skipApple(p , up.substring(5));
        }
        else{
            skipApple(p + ch , up.substring(1));
        }
    }


}
