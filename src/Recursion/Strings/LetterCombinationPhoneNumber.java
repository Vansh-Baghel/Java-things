package Recursion.Strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        System.out.println(padList("" , "23"));
//        System.out.println(googleSol("23"));
        pad("" , "23");
    }

    static void pad(String p , String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digits = up.charAt(0) - '0';

        for (int i = (digits - 2) * 3; i < (digits - 1) * 3; i++) {
            char ch = (char)('a' + i);
            pad(p + ch , up.substring(1));
        }
    }
    static ArrayList<String> padList(String p , String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digits = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        for (int i = (digits - 2) * 3; i < (digits - 1) * 3; i++) {
            char ch = (char)('a' + i);
            list.addAll(padList(p + ch , up.substring(1)));
        }
        return list;
    }

//    static ArrayList<String> googleSol(String up){
//        if (up.isEmpty()){
//            ArrayList<String> list = new ArrayList<>();
//            return list;
//        }
//
//        int digits = up.charAt(0) - '0';
//        ArrayList<String> list = new ArrayList<>();
//
//        for (int i = (digits - 2) * 3; i < (digits - 1) * 3; i++) {
//            char ch = (char)('a' + i);
//            func(up.charAt(0), ch);
//            list.addAll(googleSol(up.substring(1)));
//        }
//        return list;
//    }
//
//    static String func(char p, char ch) {
//        return ;
//    }
}
