package Leetcode;

import java.util.*;

public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] twoDArray = {
                {1,4},
                {4,5}
        };

        int[][] arr = merge(twoDArray);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int firstEl = 0, lastEl = 0, n = intervals.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            firstEl = intervals[i][0];
            lastEl = intervals[i][1];

            if (!res.isEmpty() && res.get(res.size() - 1).get(1) >= firstEl) continue;
            for (int j = i + 1; j < n; j++) {
                if (lastEl >= intervals[j][0]){
                    // It is important to assign max, because test case like [[1,4],[2,3]] might return [1,3] but its answer should be [1,4]
                    lastEl = Math.max(intervals[j][1], lastEl);
                } else break;
            }

            list.add(firstEl);
            list.add(lastEl);
            res.add(new ArrayList<>(list));
        }

        int rows = res.size();
        int cols = 2;
        int[][] arr = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            arr[i][0] = res.get(i).get(0);
            arr[i][1] = res.get(i).get(1);
        }

        return arr;
    }
}
