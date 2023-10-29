package Leetcode;

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] n = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen2(7, n));
    }

    // Run for few cases
    // Prefix sum
    static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, cnt = 0, mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += nums[j];
                cnt++;

                if (sum >= target) {
                    mini=Math.min(mini, cnt);
                    cnt = 0;
                    sum = 0;
                    break;
                }
            }
            if (mini == Integer.MAX_VALUE) return 0;
        }
        return mini;
    }

    // Sliding Window
    static int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, start = 0, mini = Integer.MAX_VALUE;

//        Running right side of the window using loop, and initializing start and changing whenever the target is reached.
        for (int end = 0; end < n; end++) {
            sum += nums[end];

            // Decreasing the window size from the left.
            while (sum >= target){
                sum-= nums[start];
                start++;
                mini = Math.min(mini, end - start + 2);
            }
        }
        return mini == Integer.MAX_VALUE ? 0 : mini;
    }
}
