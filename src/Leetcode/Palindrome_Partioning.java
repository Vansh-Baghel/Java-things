//https://leetcode.com/problems/palindrome-partitioning/
package Leetcode;
import java.util.*;

public class Palindrome_Partioning {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        getAns(s, 0, list, ans);
        return ans;
    }

    private void getAns(String s, int index, List<String> list, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
//          Checking if index till i is palindrome or not where i will increase one by one after getting checked from isPal condition.
            if (isPalindrome(s, index, i)) {
//          if it is Palindrome then add into the list.
                list.add(s.substring(index, i + 1));
//                After adding search again unless it reaches the last index.
                getAns(s, i + 1, list, ans);
//                remove the last index everytime it backtracks.
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
//            Checking from both the side , and if it is equal then it means its palindrome.
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
            return true;
    }
}