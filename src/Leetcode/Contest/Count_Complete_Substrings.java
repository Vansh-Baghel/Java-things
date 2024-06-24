package Leetcode.Contest;

public class Count_Complete_Substrings {
    public static void main(String[] args) {
        System.out.println(countCompleteSubstrings("igigee", 2));
    }

    static int countCompleteSubstrings(String word, int k) {
        int n = word.length(), last = 0, res = 0;

        // Till n because we also need last pair, warna loop will break
        for (int i = 1; i <= n; i++){
            if (i == n || Math.abs(word.charAt(i) - word.charAt(i-1)) > 2){
                res += solve(last, i - 1, word, k);
                last = i;
            }
        }

        return res;
    }

    static int solve(int start, int end, String word, int k){
        // 3 windowSizes: 1 original full length, 2nd which will change according to the unique_pairs, and 3rd which will be current length, of sliding window.
        int windowLength = (end - start) + 1, res=0;

        for (int unique_pairs = 1; unique_pairs <= 26 && unique_pairs * k <= windowLength; unique_pairs++){
            int[] freq = new int[26];
            int s = start, goodPair = 0;

            int windowSizeExpected = unique_pairs * k;

            for (int e = start; e <= end; e++){
                char ch = word.charAt(e);

                freq[ch - 'a']++;

                if (freq[ch - 'a'] == k) {
                    goodPair++;
                } else if (freq[ch - 'a'] == k + 1){
                    goodPair--;
                }

                // WindowSize same hogya, toh start toh increase kro
                if ((e - s) + 1 > windowSizeExpected){
                    if (freq[word.charAt(s) - 'a'] == k) goodPair--;
                    else if (freq[word.charAt(s) - 'a'] == k + 1) goodPair++;

                    freq[word.charAt(s) - 'a']--;
                    s++;
                }

                if (goodPair == unique_pairs) res++;
            }
        }

        return res;
    }
}
