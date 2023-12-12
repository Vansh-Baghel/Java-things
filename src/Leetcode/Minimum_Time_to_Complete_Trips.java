package Leetcode;

public class Minimum_Time_to_Complete_Trips {
    public static void main(String[] args) {
        int[] time = {10000};
        int totalTrips = 100;
        System.out.println(minimumTime(time, totalTrips));
    }

    static long minimumTime(int[] time, int totalTrips) {
        long possible=-1, e = Integer.MAX_VALUE, s = 0;

        for (int tm : time) {
            e = Math.min(e, tm);
        }

        e *= totalTrips;

        while (s <= e){
            long m = s + (e - s)/2, sum = 0;

            for (int num: time){
                if (num <= m){
                    sum+= m/num;
                }
            }

            if (sum >= totalTrips){
                possible = m;
                e = m - 1;
            } else s = m + 1;
        }

        return possible;
    }
}
