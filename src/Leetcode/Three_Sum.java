package Leetcode;

import java.util.*;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum2(nums));
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum = nums[i] + nums[j];

                for (int k = j+1; k < n; k++) {
                    if (-nums[k] == sum) {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        if (!ans.contains(ls)) ans.add(ls);
                    }
                }
            }
        }

        return ans;
    }

    static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            findDif(i, ans, nums, -nums[i]);
        }
        return ans;
    }

    private static void findDif(int i, List<List<Integer>> ans, int[] nums, int target) {
        int j = i+1, k = nums.length - 1;

        while (j < k) {
            int sum = nums[j] + nums[k];
            if (sum == target) {
                addInAns(ans, i, j, k, nums);

                while (j < k && nums[j] == nums[j + 1]) j++;
                while (j < k && nums[k] == nums[k - 1]) k--;

                j++;
                k--;
            } else if (sum > target) k--;
            else j++;
        }
    }

    private static void addInAns(List<List<Integer>> ans, int i, int j, int k, int[] nums) {
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[i]);
        ls.add(nums[j]);
        ls.add(nums[k]);
        ans.add(ls);
    }
}
