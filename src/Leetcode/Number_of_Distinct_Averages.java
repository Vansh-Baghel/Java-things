package Leetcode;

import java.util.*;

public class Number_of_Distinct_Averages {
    public static void main(String[] args) {
        int[] arr = {9,5,7,8,7,9,8,2,0,7};
        System.out.println(distinctAverages(arr));
    }

    static int distinctAverages(int[] nums) {
        int s = 0, e = nums.length - 1;

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        HashSet<Double> hs = new HashSet<>();

        while (s < e){
            double div = ((nums[e--] + nums[s++]) / 2.0);
            hs.add(div);
        }
        return hs.size();
    }
}
