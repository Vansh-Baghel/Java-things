package Leetcode.Contest;

public class Remove_Adjacent_Almost_Equal_Characters {
    public static void main(String[] args) {
        System.out.println(removeAlmostEqualCharacters("zyxyxyz"));
    }
        static int removeAlmostEqualCharacters(String word) {
            int e = 1, n = word.length(), prevIdx = -1, res = 0;

            while (e < n){
                if (word.charAt(e) == word.charAt(e - 1) || Math.abs(word.charAt(e) - word.charAt(e - 1)) == 1){
                    if (prevIdx != e - 1) {
                        prevIdx = e;
                        res++;
                    }
                }
                e++;
            }

            return res;
        }
}
