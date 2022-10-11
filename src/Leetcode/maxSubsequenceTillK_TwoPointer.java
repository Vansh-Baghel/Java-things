//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
package Leetcode;

public class maxSubsequenceTillK_TwoPointer {
    public static void main(String[] args) {

    }

    public int maxSubsequence(int[] nums, int k) {
        int s = 0;
        int e = 0;
        int windowSum = 0;
        int maxSum = 0;

        while (e < k){
            windowSum += nums[e++];
        }
        while (e < nums.length){
            windowSum += nums[e++] - nums[s++];
            maxSum= Math.max(maxSum , windowSum);
        }
        return maxSum;
    }
}
