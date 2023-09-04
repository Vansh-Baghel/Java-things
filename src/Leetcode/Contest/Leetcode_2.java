//https://leetcode.com/problems/find-the-minimum-possible-sum-of-a-beautiful-array/description/
package Leetcode.Contest;

import java.util.*;

public class Leetcode_2 {
    public static void main(String[] args) {
        long ans = minimumPossibleSum(2, 3);
        System.out.println(ans);
        System.out.println(1+2+3+6+7+8+9+10+11+12+13+14+15+16+17+18);
    }
    static long minimumPossibleSum(int n, int target) {
        long ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        int num = 1;
        int idx = 0;

        while (idx < n){
            if (!hs.contains(target - num)){
                hs.add(num);
                ans+=num;
                hs.add(target - num);
                idx++;
            }
            num++;
        }
        return ans;
    }
}
