package Leetcode;

public class Find_the_Highest_Altitude {
    public static void main(String[] args) {
        int[] arr = {-5,1,5,0,-7};
        System.out.println(largestAltitude(arr));
    }

    static int largestAltitude(int[] gain) {
        int n = gain.length, maxi = 0;
        int[] prefix = new int[n+1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i+1] = gain[i] + prefix[i];
            maxi = Math.max(maxi, prefix[i + 1]);
        }

        return maxi;
    }
}
