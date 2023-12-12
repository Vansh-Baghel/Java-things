package Leetcode;

public class Minimum_Speed_to_Arrive_on_Time {
    public static void main(String[] args) {
        int[] arr={1,1,100000};
        int[] arr2={1,3,2};
        System.out.println(minSpeedOnTime2(arr,2.01));
//        System.out.println(minSpeedOnTime2(arr2,2.7));
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
























    static int minSpeedOnTime2(int[] dist, double hour) {
        int s = 1, e = (int)1e7, res = -1;

        while (s <= e){
            int m = s + (e - s) / 2;
            double speed = calculateSpeed(m, dist);

            if (speed <= hour){
                res = m;
                e = m - 1;
            } else s = m + 1;
        }
        return res;
    }

    private static double calculateSpeed(int m, int[] dist) {
        double speed = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            speed += Math.ceil((double)dist[i]/m);
        }

        // last element decimal chalega
        speed += (double)dist[dist.length-1]/m;

        return speed;
    }
}
