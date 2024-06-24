package Leetcode.Contest;

import java.util.HashSet;

public class Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {
    public static void main(String[] args) {
        int[] arr={1,2,3,5};
        System.out.println(missingInteger(arr));
    }

    static int missingInteger(int[] nums) {
        int n = nums.length, sum = nums[0];
        HashSet<Integer> hs = new HashSet<>();

        for (int num: nums) hs.add(num);

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 != nums[i]) break;
            sum += nums[i];
        }

        while (true){
            if(!hs.contains(sum)) return sum;
            sum++;
        }
    }
}
