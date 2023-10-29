package Leetcode;

import java.util.Arrays;
import java.util.List;

public class Three_Sum_Closest {
    public static void main(String[] args) {
        int[] n = {1,1,1,0};
        System.out.println(threeSumClosest(n, -100));
    }

    static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = -1, minAbsDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];

                int absDiff = Math.abs(sum - target);
                if (absDiff < minAbsDiff) {
                    ans = sum;
                    minAbsDiff = absDiff;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                } else {
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    j++;
                }

            }
        }
                return ans;
    }
}
