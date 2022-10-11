package Leetcode;
import java.util.*;

public class Longest_Common_Prefix {
    public static void main(String[] args) {

    }

    static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
//        StringBuilder is mutable and string is not . Thats it!! Here we won't create new objects in the pool which will save the memory. Also , we can use StringBuilder methods like append and all.
        StringBuilder result = new StringBuilder();

//      Here we are converting the given string into array and traversing through it .

//        For first string
        char[] s = strs[0].toCharArray();

//        For last string
        char[] e = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] != e[i]) {
                break;
            }
//            If if condition is false , then keep appending the letters in the result.
            result.append(s[i]);
        }

//      Here toString is converting the stringbuilder into string because the return type is string.
        return result.toString();
    }
}
