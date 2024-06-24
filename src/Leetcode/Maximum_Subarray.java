//https://leetcode.com/problems/maximum-subarray/
package Leetcode;

public class Maximum_Subarray {
    public static void main(String[] args) {
        int[] n = {-1};
        System.out.println(maxSubArray(n));
    }

    static int maxSubArray(int[] nums) {
//      MIN_VALUE because if nums value contains negative elements then curSum will be negative so maxSum must be smaller than it to get added as maxSum.
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
//          Keep adding the next number in curSum
            curSum += nums[i];

//          Update the maxSum if curSum goes greater than maxSum
            if(curSum > maxSum){
                maxSum = curSum;
            }
//          If curSum goes smaller than 0 , than reset the curSum and go to the next element.
            if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;
    }












    static int maxSubArray2(int[] nums) {
        int sum = 0, maxi = Integer.MIN_VALUE;

        for (int num: nums){
            sum += num;

            maxi = Math.max(maxi, sum);
            if (sum < 0) sum = 0;
        }

        return maxi;
    }
}
