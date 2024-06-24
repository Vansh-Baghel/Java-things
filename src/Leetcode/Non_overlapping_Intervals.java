package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length, cnt = 0, j = 1, i = 0;

        while (j < n) {
            int[] curInterval = intervals[i];
            int[] nxtInterval = intervals[j];

            int cs = curInterval[0];
            int ce = curInterval[1];
            int ns = nxtInterval[0];
            int ne = nxtInterval[1];

            // Non overlapping
            if (ce <= ns) {
                i = j;
                j++;
                // Overlapping
            } else if (ce > ne) {
                i = j;
                j++;
                cnt++;
            } else {
                j++;
                cnt++;
            }
        }

        return cnt;
    }

    static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length, cnt = 0, j = 1, i = 0;

        while (j < n){
            int[] curInterval = intervals[i];
            int[] nxtInterval = intervals[j];

            int cs = curInterval[0];
            int ce = curInterval[1];
            int ns = nxtInterval[0];
            int ne = nxtInterval[1];

            // Non overlapping
            if (ce <= ns){
                i = j;
                j++;
            // Overlapping
            } else {
                // Removing the larger range wala pair. Cannot do this because there are negative range as well. Therefore just check the end wala element
//                int dif1= ce - cs;
//                int dif2= ne - ns;

//                if (dif1 > dif2){
//                    i = j;
//                }
//                j++;
//                cnt++;

                if (ne <= ce) {
                    i = j;
                }
                j++;
                cnt++;
            }
        }

        return cnt;
    }
}
