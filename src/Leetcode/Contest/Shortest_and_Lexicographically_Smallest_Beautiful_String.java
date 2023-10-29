package Leetcode.Contest;

import java.util.*;

public class Shortest_and_Lexicographically_Smallest_Beautiful_String {
    public static void main(String[] args) {
        String ans = shortestBeautifulSubstring("01011101000111110", 5);
        System.out.println(ans);
    }

    static String shortestBeautifulSubstring(String s, int k) {
        ArrayList<String> strList = new ArrayList<>();
        int n = s.toCharArray().length;
        int start = 0, oneCnt = 0, minLength = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            if (s.charAt(end) == '1') oneCnt++;

            while (oneCnt == k) {
                if (s.charAt(start) == '1') oneCnt--;

                if (minLength > (end - start) + 1){
                    minLength = (end - start) + 1;
                    strList = new ArrayList<>();
                }

                if (minLength == (end - start) + 1){
                    strList.add(s.substring(start, end+1));
                }

                start++;
            }
        }

        Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        // Sort the collection based on string length
        Collections.sort(strList, lengthComparator);

        return strList.isEmpty() ? "" : strList.get(0);
    }
}
