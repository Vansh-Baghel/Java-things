package Leetcode;
import java.util.*;

public class Letters_Collection {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 10},
                {5, 6, 7, 8, 10},
                {9, 1, 3, 4, 10},
                {1, 2, 3, 4, 10}};

        int n = mat.length;
        int m = mat[0].length;
        int q = 2;
        int queries[][] = {{1, 0, 1}, {2, 0, 1}};
        System.out.println(matrixSum(n,m,mat,q,queries));
    }
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][]){
        // code here
        int[] rDel={-1,-1,-1,0,0,1,1,1};
        int[] cDel ={-1,0,1,-1,1,-1,0,1};
        int[] rDel2={-2,-2,-2,-2,-2,-1,-1,0,0,1,1,2,2,2,2,2,};
        int[] cDel2={-2,-1,0,1,2,-2,2,-2,2,-2,2,-2,-1,0,1,2 };
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 1) {
                ans.add(findSum(mat, queries[i][1], queries[i][2], rDel, cDel));
            } else ans.add(findSum(mat, queries[i][1], queries[i][2], rDel2, cDel2));
        }

        return ans;
    }

    private static int findSum(int[][] mat, int row, int col, int[] rDel, int[] cDel) {
        int ans = 0;

        for (int i = 0; i < rDel.length; i++) {
            int r = row + rDel[i];
            int c = col + cDel[i];

            if (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length) ans += mat[r][c];
        }

        return ans;
    }
}
