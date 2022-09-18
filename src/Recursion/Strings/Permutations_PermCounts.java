package Recursion.Strings;

import java.util.ArrayList;

public class Permutations_PermCounts {
    public static void main(String[] args) {
        ArrayList<String> ans = permutations("" , "abc");
        System.out.println(ans);
        System.out.println(countPermutations("","abc"));
    }

    static ArrayList<String> permutations(String p, String up) {
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0 , i);
            String s = p.substring(i , p.length());
            list.addAll(permutations(f + ch + s, up.substring(1)));
        }
            return list;
    }

    static int countPermutations(String p , String up){
        if (up.isEmpty()){
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length() ; i++) {
            String f = p.substring(0 , i);
            String s = p.substring(i , p.length());
            count = count + countPermutations(f + ch + s, up.substring(1));
        }
        return count;
    }
}
