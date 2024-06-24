package Leetcode;

import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {
    static class Tuple{
        int st;
        int end;
        int profit;

        Tuple(int st, int end, int profit){
            this.st = st;
            this.end = end;
            this.profit = profit;
        }
    }

    static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Tuple> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            intervals.add(new Tuple(startTime[i], endTime[i], profit[i]));
        }

        intervals.sort(Comparator.comparingInt(tuple -> tuple.st));

        return maxTime(0, -1, n, intervals);
    }

    private static int maxTime(int idx, int prev, int n, List<Tuple> intervals) {
        if (idx >= n) return 0;

        int pick = 0;

        if (prev <= intervals.get(idx).st) pick = intervals.get(idx).profit + maxTime(idx + 1, intervals.get(idx).end, n, intervals);

        int notPick = maxTime(idx + 1, prev, n, intervals);

        return Math.max(notPick, pick);
    }

    // Tuple ka bhi need nhi
    static int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n];
        int[][] intervals = new int[n][3];

        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }

        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        return maxTime(0, n, dp, intervals);
    }

    private static int maxTime(int idx, int n, int[] dp, int[][] intervals) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];

        int index = getNextIndex(intervals, intervals[idx][1]);
        if (index < 0) index = -index - 1;

        int pick = intervals[idx][2] + maxTime(index, n, dp, intervals);
        int notPick = maxTime(idx + 1, n, dp, intervals);

        return dp[idx] = Math.max(notPick, pick);
    }

    static int getNextIndex(int[][] intervals ,int val){
        //implement BS
        int low = 0;
        int high = intervals.length;

        while(low < high){

            int mid = low + (high-low)/2;

            if(intervals[mid][0] < val){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return high;
    }
}
