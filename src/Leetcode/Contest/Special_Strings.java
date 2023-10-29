package Leetcode.Contest;

public class Special_Strings {
    public static void main(String[] args) {
        String s= "zyt";
        int n = s.length();
        System.out.println(specialStrings2(n,s));
    }

    static int specialStrings(int N, String S) {
        // Code here.
        return totalWays(0, 26, 26, 0, S);
    }

    static int totalWays(int idx, int last, int second_last, int isCurLarge, String s) {
        if (idx == s.length()) return isCurLarge;

        int ans = 0;

        // Storing the number for the current ch
        int cur = s.charAt(idx) - 'a';

        // Lexographically greater pairs hone chahiye, so if adb hai toh adc cannot be a pair because c is smaller than d.
        if (isCurLarge == 1){
            // Agar current large hai, toh fir run from a to z purra.
            cur = 0;
        }

        for (int ch = cur; ch < 26; ch++) {
            // Handling the palindrome condition
            if (ch == last || ch == second_last) continue;

            if (ch > cur) isCurLarge = 1;
            ans += totalWays(idx+1, ch, last, isCurLarge, s);
        }

        return ans;
    }

    static int specialStrings2(int N, String S) {
        int[][][][] dp = new int[101][27][27][2];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j <= 26; j++) {
                for (int k = 0; k <= 26; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        // Code here.
        return totalWays2(0, 26, 26, 0, S, dp);
    }

    static int mod = (int)(1e9 + 7);

    static int totalWays2(int idx, int last, int second_last, int isCurLarge, String s, int[][][][] dp) {
        if (idx == s.length()) return isCurLarge;

        if (dp[idx][last][second_last][isCurLarge] != -1) return dp[idx][last][second_last][isCurLarge];

        // Storing the number for the current ch
        int cur = s.charAt(idx) - 'a';

        // Lexographically greater pairs hone chahiye, so if adb hai toh adc cannot be a pair because c is smaller than d.
        if (isCurLarge == 1){
            // Agar current large hai, toh fir run from a to z purra.
            cur = 0;
        }

        for (int ch = cur; ch < 26; ch++) {
            // Handling the palindrome condition
            if (ch == last || ch == second_last) continue;

            if (ch > cur) isCurLarge = 1;

            dp[idx][last][second_last][isCurLarge] += totalWays2(idx+1, ch, last, isCurLarge, s, dp);
            dp[idx][last][second_last][isCurLarge] %= mod;
        }

        return dp[idx][last][second_last][isCurLarge];
    }
}
