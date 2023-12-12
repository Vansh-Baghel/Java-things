package Leetcode;

public class Maximum_Running_Time_of_N_Computers {
    public static void main(String[] args) {
        int[] b = {10,10,3,5};
        System.out.println(maxRunTime(3, b));
    }
    static long maxRunTime(int n, int[] batteries) {
        long ans = 0, s = 0, e = 0;

        for (int battery : batteries) {
            s = Math.min(s, battery);
            e += battery;
        }

        while (s <= e){
            long m = s + (e - s) / 2;

            if (isValid(m, n, batteries)){
                ans = m;
                s = m + 1;
            } else e = m - 1;
        }
        return ans;
    }

    private static boolean isValid(long m, int n, int[] batteries) {
        long maxSum = m * n;

        for (int battery : batteries) {

            // Math.min because m here is the size of each battery which we have considered so if any battery value is greater than it, we have to take the smaller value.
            maxSum -= Math.min(battery, m);

            if (maxSum <= 0) return true;
        }
        return false;
    }
}
