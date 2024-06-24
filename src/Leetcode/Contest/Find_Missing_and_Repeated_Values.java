package Leetcode.Contest;

public class Find_Missing_and_Repeated_Values {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[(n * n) + 1], res = new int[2];

        for (int[] nums: grid){
            for (int num: nums){
                arr[num]++;
            }
        }

        for (int i = 1; i < n * n + 1; i++) {
            if (arr[i] > 1) res[0] = i;
            if (arr[i] == 0) res[1] = i;
        }

        return res;
    }
}
