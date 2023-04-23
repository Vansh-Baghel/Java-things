package Leetcode;

public class Count_prefixes_of_a_given_string {
    public static void main(String[] args) {
        String[] arr = {"a","b","c","ab","bc","abc"};
        int ans = countPrefixes(arr , "a");
        System.out.println(ans);
    }

    static int countPrefixes(String[] words, String s) {
        int c = 0;

        for (String word : words){
            // word will always be smaller or equal to the s. Therefore this condition will be valid. Even if its not, then will only consider the length of s to check the substring.
            if (s.startsWith(word)) c++;
        }

        return c;
    }
}
