package Leetcode;

import java.util.*;

public class Find_duplicate_rows_in_a_binary_matrix {
    static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n){
        //code here
        HashSet<String> hs = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            StringBuilder s = new StringBuilder();
            for (int c = 0; c < n; c++) {
                s.append(matrix[r][c]);
            }

            if (hs.contains(s.toString())) res.add(r);
            else hs.add(s.toString());
        }

        return res;
    }
}
