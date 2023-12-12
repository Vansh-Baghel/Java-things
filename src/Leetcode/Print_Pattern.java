package Leetcode;

import java.util.*;

public class Print_Pattern {
    public static void main(String[] args) {
        System.out.println(pattern(16));
    }

    static List<Integer> pattern(int N){
        List<Integer> ans = new ArrayList<>();
        int[] num = new int[]{N};

        if (N <= 0) {
            ans.add(N);
            return ans;
        }

        if (num[0] > 0) decreaseNum(num, 5, ans);
        if (num[0] != N) increaseNum(num, N, 5, ans);

        return ans;
    }

    private static void increaseNum(int[] num, int N, int i, List<Integer> ans) {
        if (num[0] > N) return;

        ans.add(num[0]);
        num[0]+=i;
        increaseNum(num, N, i, ans);
    }

    private static void decreaseNum(int[] num, int i, List<Integer> ans) {
        if (num[0] < 0 || num[0] == 0) return;

        ans.add(num[0]);
        num[0]-=i;
        decreaseNum(num, i, ans);
    }
}
