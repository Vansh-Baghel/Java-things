//https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-118/problems
package Leetcode.Contest;

import java.util.HashSet;

public class Even_Sum {
    public static void main(String[] args) {
        int[] arr = {850161191, 848123532, 828928141, 594389784, 415880621, 826625820, 161927018, 620818509, 221058707, 476884874};
        int ans = findMin(arr, 10);
        System.out.println(ans);
    }

    static int findMin(int A[], int n) {
        int sum = 0;
        int ans = (int)(1e9);
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }

        if (sum % 2 == 0) return 0;
        else {
            for (int i = 0; i < A.length; i++) {
                int oper = 0;

                if (!hs.contains(A[i]) && A[i] % 2 == 0){
                    hs.add(A[i]);
                    while (A[i] % 2 == 0){
                        A[i] = A[i] / 2;
                        oper++;
                    }
                    ans = Math.min(ans, oper);
                }
            }
        }
        return ans == 1e9 ? -1 : ans;
    }
}
