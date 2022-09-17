package Recursion.Strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        System.out.println(subSeqArray("" , "abc"));
        subseq("" , "abc");
    }
    static ArrayList<String> subSeqArray(String p, String up) {
        if (up.isEmpty()){
            ArrayList<String> list  = new ArrayList<String>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subSeqArray(p + ch , up.substring(1));
        ArrayList<String> right = subSeqArray(p , up.substring(1));

        left.addAll(right);
//      Can return any , left or right because both are the same.
        return left;
    }
    static void subseq(String p, String up) {
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
//      Adding the character
        subseq(p + ch , up.substring(1));
//      Ignoring the character
        subseq(p , up.substring(1));
    }


}
