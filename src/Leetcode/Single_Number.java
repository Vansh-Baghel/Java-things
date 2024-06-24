package Leetcode;

public class Single_Number {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        int res = 0;

        for (int num: nums){
            // n ^ m = n + m, but if same num occurs, it will subtract it.
            // Eg: 4,1,2,1,2. res = 4 + 1 + 2 - (1) - (2) = 4.
            res = res ^ num;
        }

        return res;
    }
}
