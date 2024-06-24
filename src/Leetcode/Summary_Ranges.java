package Leetcode;

import java.util.*;

public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, s = 0, e = 1;
        List<String> res = new ArrayList<>();

        while (e < n) {
            if (nums[e] == nums[e - 1] + 1){
                while (e < n && nums[e] == nums[e - 1] + 1){
                    e++;
                }
                res.add(nums[s] + "->" + nums[e-1]);
            }
            else {
                while (e < n && nums[e] == nums[e - 1]){
                    e++;
                }
                res.add(nums[s] + "");
            }
            s = e;
            e++;
        }

        if (s == n - 1) res.add(nums[s] + "");

        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        int n = nums.length, s = 0, e = 0;
        List<String> res = new ArrayList<>();

        while (e < n) {
            while (e < n - 1 && nums[e] + 1 == nums[e + 1]){
                e++;
            }

            if (nums[s] != nums[e]) res.add(nums[s] + "->" + nums[e]);
            else res.add(nums[s] + "");
            s = e + 1;
            e++;
        }

        return res;
    }
}
