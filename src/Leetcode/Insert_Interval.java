package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Insert_Interval {
    public static void main(String[] args) {
        int[][] arr = {
                {1,5}
        };
        int[] narr = {6,8};

        int[][] ans = insert(arr, narr);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int firstEl = 0, lastEl = 0, n = intervals.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list = new ArrayList<>();

            firstEl = intervals[i][0];
            lastEl = intervals[i][1];

            if (!res.isEmpty() && res.get(res.size() - 1).get(1) >= firstEl) continue;

            if (flag && newInterval[0] <= lastEl) {
                firstEl = Math.min(intervals[i][0], newInterval[0]);
                lastEl = Math.max(newInterval[1], lastEl);
                flag = false;

                for (int j = i+1; j < n; j++) {
                    if (lastEl >= intervals[j][0]) {
                        lastEl = Math.max(intervals[j][1], lastEl);
                    } else break;
                }
            }

            list.add(firstEl);
            list.add(lastEl);
            res.add(new ArrayList<>(list));
        }

        if (flag) {
            list = new ArrayList<>();
            list.add(newInterval[0]);
            list.add(Math.max(newInterval[1], lastEl));
            res.add(list);
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
    static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0){
            res.add(newInterval);
            return res.toArray( new int[res.size()][]);
        }
        boolean isUsed= false;

        for(int []interval : intervals ){
            if(!isUsed && interval[0]>newInterval[1]){
                res.add(newInterval);
                res.add(interval);
                isUsed = true;
            } else if(!isUsed && interval[1]>=newInterval[0]){
                //modify the newIndex if overlap is found
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }else{
                //if current interval does not overlap with newInterval
                res.add(interval);
            }
        }
        //if the newinterval has not been inserted -> insert at the end.
        if(!isUsed){
            res.add(newInterval);
        }
        return res.toArray( new int[res.size()][]);
    }

    static int[][] insert3(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n) {
            if(intervals[i][1]<newInterval[0]) res.add(intervals[i]);
            else if(intervals[i][0]>newInterval[1]) break;
            else
            {
                //Merge
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            }
            i++;
        }
        res.add(newInterval);
        while(i<n)
        {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
