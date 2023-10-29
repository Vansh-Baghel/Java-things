package Leetcode;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(nums));
    }

    static int trap(int[] height) {
        int n = height.length, maxi = 0, mini = Integer.MAX_VALUE, ans = 0;
        int[] min = new int[n], max= new int[n];

        for (int i = 0; i < n; i++) {
            maxi = Integer.max(maxi, height[i]);
            min[i] = maxi;
        }

        maxi=0;

        for (int i = n-1; i >= 0; i--) {
            maxi = Integer.max(maxi, height[i]);
            max[i] = maxi;
        }

        for (int i = 1; i < n-1; i++) {
            mini = Integer.min(min[i], max[i]);
            ans += mini - height[i];
        }

        return ans;
    }
}
