package Leetcode;

import java.util.*;

public class Beautiful_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray2(5)));
    }

    public static int[] beautifulArray(int n) {
        int[] vis = new int[n+1], res = new int[n];
        int i = 0;
        List<Integer> tmp = new ArrayList<>();
        solve(vis, tmp, 0, n);

        for (int num: tmp){
            res[i++] = num;
        }

        return res;
    }

    public static boolean solve(int[] vis, List<Integer> res, int idx, int n){
        if (idx >= n) {
            if (isBeautiful(res)) return true;
            else return false;
        }

        for (int i = 1; i <= n; i++){
            if (vis[i] == 0){
                res.add(i);
                vis[i] = 1;
                if (solve(vis, res, idx + 1, n)) return true;
                res.remove(res.size() - 1);
                vis[i] = 0;
            }
        }

        return false;
    }

    public static boolean isBeautiful(List<Integer> res){
        int n = res.size();

        for (int i = 0; i < n; i++){
            HashSet<Integer> hs = new HashSet<>();

            for (int j = i + 1; j < n; j++){
                int numToFind = (res.get(i) + res.get(j)) / 2;
                if (hs.contains(numToFind)) return false;
                hs.add(res.get(j));
            }
        }

        return true;
    }

    public static int[] beautifulArray2(int n) {
        if (n == 1) return new int[]{1};

        int[] res = new int[n];

        // When n is odd, then n + 1 size will be larger than right. EG: If n = 3; (n + 1) / 2 will give 2, whereas n / 2 will give 1.
        int[] left = beautifulArray2((n + 1) / 2 );
        int[] right = beautifulArray2(n / 2);

        // Even numbers should be on the right
        for (int i = left.length; i < n; i++){
            res[i] = right[i - left.length] * 2;
        }

        for (int i = 0; i < left.length; i++) {
            res[i] = left[i] * 2 - 1;
        }

        return res;
    }
}
