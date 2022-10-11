//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
package Leetcode;

public class Index_of_First_Occurence {
    public static void main(String[] args) {

    }

    static int strStr(String haystack, String needle) {
//        i will only go till there because there's no meaning in checking the elements beyond which the length of needle is less . EG: - haystack = abcde , needle = cde , then i will only go till c , because beyond that the length of string is 2 and needle itself is 3.
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            If the char matches , then check the substring .
            if (haystack.charAt(i) == needle.charAt(0)){
//                If the substring matches , then ans found!!
                if(haystack.substring(i , needle.length() + i).equals(needle)){
                    return i;
                }
            }
        }
//        Otherwise in any other case, answer doesn't exist.
    return -1;
    }
}
