package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Equal_Row_and_Column_Pairs {
    public static void main(String[] args) {
        int[][] grid = {{11,1},{1,11}};
        System.out.println(equalPairs(grid));
    }

    static int equalPairs(int[][] grid) {
        HashMap<String, Integer> hm = new HashMap<>();
        int ans = 0;

        for(int[] r: grid){
            StringBuilder str = new StringBuilder();
            for(int c: r){
                str.append(c);
                str.append(',');
            }
            hm.put(str.toString(), hm.getOrDefault(str.toString(), 0)+1);
        }

        for (int row = 0; row < grid.length; row++) {
            StringBuilder str = new StringBuilder();
            for (int col = 0; col < grid[0].length; col++) {
                str.append(grid[col][row]);
                str.append(',');
            }
            if (hm.containsKey(str.toString())) {
                ans += hm.get(str.toString());
            };
        }

        return ans;
    }
}
