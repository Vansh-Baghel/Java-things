package Leetcode;
import java.util.*;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("geeks"));
    }

    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionMaker(s, 0, list, ans);
        return ans;
    }

    static void partitionMaker(String s, int index, List<String> list, List<List<String>> ans) {
        if (index == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
                if (isPalindromeSeq(s, index, i, list, ans)){
                    list.add(s.substring(index , i+1));
                    partitionMaker(s,i+1, list,ans);
                    list.remove(list.size() - 1);
                }
//                return ans;
            }
    }

    static boolean isPalindromeSeq(String s, int i, int j, List<String> list, List<List<String>> ans) {
        int l = i;
        int r = j;

        while (l <= r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
