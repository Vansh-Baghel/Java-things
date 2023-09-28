package Leetcode;

public class Minimum_insertions_to_make_a_string_palindrome {
    public static void main(String[] args) {
        System.out.println(minInsertion("vuuztmsu"));
    }
    public static int minInsertion(String str) {
        StringBuilder temp = new StringBuilder(str);
        int n = str.length();
        temp.reverse();
        int longestPalindrome = findLongestPalindromeSubsequence(str, temp.toString());

        return n - longestPalindrome;
    }

    private static int findLongestPalindromeSubsequence(String str1, String str2) {
        int n = str1.length();

        // str2 is just reverse, so size is same
        int[][] dp= new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= n; idx2++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                else{
                    int pick = dp[idx1-1][idx2];
                    int notPick = dp[idx1][idx2-1];
                    dp[idx1][idx2] = Math.max(pick, notPick);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][n];
    }

    // This should work fine, but prev is also getting change even when we are just changing the cur.
    private static int findLongestPalindromeSubsequence2(String str1, String str2) {
        int n = str1.length();

        // str2 is just reverse, so size is same
        int[] prev= new int[n+1];
        int[] cur= new int[n+1];

        for (int i = 0; i <= n; i++) {
            prev[i] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= n; idx2++) {
                if (str1.charAt(idx1-1) == str2.charAt(idx2-1)) cur[idx2] = 1 + prev[idx2-1];
                else{
                    int pick = prev[idx2];
                    int notPick = cur[idx2-1];
                    cur[idx2] = Math.max(pick, notPick);
                }
            }
            prev=cur;
        }

        for (int i = 0; i <= n; i++) {
            System.out.print(prev[i] + " ");
        }
        return prev[n];
    }
}
