package Leetcode;

public class Max_Consecutive_Ones_III {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        int k = 3;
        System.out.println(longestOnes(arr, k));
    }

    static int longestOnes(int[] nums, int k) {
        int n = nums.length, cnt = 0, ans=0, s=0;

        for (int e = 0; e < n; e++) {
            if (nums[e] == 1 || cnt<k){
                if (nums[e] == 0) cnt++;
            } else {
                ans = Math.max(ans, e-s);
                while (nums[s]!=0) s++;
                s++;
                cnt--;
                if (nums[e] == 0) cnt++;
            }
        }

        ans = Math.max(ans, n-s);

        return ans;
    }
}
