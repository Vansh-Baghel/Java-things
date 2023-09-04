//https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-118/problems
package Leetcode.Contest;

public class Explosives {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1};
        int ans = maxBoxes(12,2,1,arr);
        System.out.println(ans);
    }
    static int maxBoxes(int N, int K, int C, int col[]) {
        int totalExp = 0;
        int count = 0;
        int ans = 0;
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < col.length - 1; i++) {
            if (col[i] == col[i+1] && col[i] == C){
                totalExp = 2;
                p1=i-1;
                p2=i+2;

                while (p1 >= 0 && p2 < N && col[p1] == col[p2]){
                    count = 2;
                    p1--;
                    p2++;

                    if(p1 >= 0 && col[p1] == col[p1+1]){
                        p1--;
                        count++;
                    } if(p2 < N && col[p2] == col[p2-1]){
                        p2++;
                        count++;
                    }
                    if(count >= 3){
                        totalExp += count;
                    } else {
                        break;
                    }
                }
                // ans mai Math.max because if multiple places par agar color explode honge, toh we need only need to take that jisme zyada explosions hore ho, else it will return the last occurence of repetition.
                ans = Math.max(ans, totalExp);
                }
            }
        return ans;
    }
}
