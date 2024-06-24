package Leetcode;

import java.util.*;

public class Minimum_Operations_to_Make_a_Uni_Value_Grid {
    public static void main(String[] args) {
        int[][] arr = {{931,128}, {639,712}};
        System.out.println(minOperations(arr, 73));
    }

    static int minOperations(int[][] grid, int x) {
        // modulus because if all the elements are mod is same, only then they could be equal.
        // EG: {4,8,12,16,20}, x = 3. We will try to
        int n = grid.length, m = grid[0].length, idx = 0, res = 0, modulus = grid[0][0] % x;
        int[] arr = new int[n*m];

        for (int[] row: grid){
            for (int num: row){
                if (num % x != modulus) return -1;
                arr[idx++] = num;
            }
        }

        Arrays.sort(arr);
        int mid = arr[arr.length / 2];

        for (int num: arr){
            res += Math.abs(mid - num) / x;
        }

        return res;
    }

    public int countKeyChanges(String s) {
        int i = 0, n=s.length(), res = 0;
        s = s.toLowerCase();
        while (i < n){
            while (i < n - 1 && s.charAt(i) == s.charAt(i+1)){
                i++;
            }
            res++;
            i++;
        }

        return res;
    }
}
