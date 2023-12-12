package Leetcode;

public class Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";

        System.out.println(minimumRecolors(blocks, 7));
    }

    static int minimumRecolors(String blocks, int k) {
        int s = 0, e = 0, ans = Integer.MAX_VALUE, cnt = 0;

        while (e < blocks.length()){
            if (blocks.charAt(e) == 'W') cnt++;

            if ((e - s) + 1 < k) {
                e++;
            } else if ((e - s) + 1 == k){
                ans = Math.min(ans, cnt);

                if (blocks.charAt(s) == 'W') cnt--;
                s++;
                e--;
            }
        }

        return ans;
    }
}
