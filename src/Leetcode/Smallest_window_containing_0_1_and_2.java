package Leetcode;

public class Smallest_window_containing_0_1_and_2 {
    public static void main(String[] args) {
        System.out.println(smallestSubstring("1210"));
    }

    static int smallestSubstring(String S) {
        // Code here
        int[] alpha = new int[3];
        int n = S.length(), s = 0, possible = Integer.MAX_VALUE;

        for (int e = 0; e < n; e++) {
            alpha[S.charAt(e) - '0']++;

            if (e >= 2) {
                while (doesContainAll(alpha)) {
                    possible = Math.min((e - s) + 1, possible);
                    alpha[S.charAt(s) - '0']--;
                    s++;
                }
            }
        }

        return possible == Integer.MAX_VALUE ? -1 : possible;
    }

    static boolean doesContainAll(int[] alpha) {
        for (int i = 0; i < 3; i++) {
            if (alpha[i] <= 0) return false;
        }
        return true;
    }
}
