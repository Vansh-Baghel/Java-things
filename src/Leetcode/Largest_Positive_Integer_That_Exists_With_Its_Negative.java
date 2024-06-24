package Leetcode;

import java.util.HashSet;

public class Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public static void main(String[] args) {
        int[] arr = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(arr));
    }

    public static int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int res = -1;

        for (int num: nums){
            if (hs.contains(num * -1)){
                if (num < 0) num *= -1;
                res = Math.max(num, res);
            } else hs.add(num);
        }

        return res;
    }
}
