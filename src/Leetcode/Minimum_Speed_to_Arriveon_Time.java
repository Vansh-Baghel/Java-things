package Leetcode;
import java.util.*;

public class Minimum_Speed_to_Arriveon_Time {
    public static void main(String[] args) {
        int[] arr={1,1,100000};
        System.out.println(minSpeedOnTime(arr,2.01));
    }

    static double timeTaken(int[] dist, int l, int r, int m){
        int n = dist.length;
        double t=0;

        for(int i=0 ; i<n-1 ; i++) {
            t += Math.ceil((double)dist[i]/m);
        }
        // Last element can be decimal
        t += (double)dist[n-1]/m;

        return t;
    }

    static int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int s=1;

        // 1e7 means 10^7.
        int e=(int)1e7;
        int ans=-1;

        // This condition because we have the constraint that each train will atleast take 1 hour.
        if (n - 1 >= hour) return -1;

        while(s<e){
            int m=s+(e-s)/2;

            double t = timeTaken(dist,s,e,m);

            if (t<=hour)e=m;
            else s=m+1;
        }
        return s;
    }
}
