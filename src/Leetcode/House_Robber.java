//https://leetcode.com/problems/house-robber/
package Leetcode;

public class House_Robber {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            int[] newArr = new int[nums.length + 1];

            newArr[0] = 0;
            newArr[1] = nums[0];

            for (int i = 1; i < nums.length; i++) {
    //           If nums is [1,2,3,1,2] then newArr = [0,1,2,4,4,6] . We are comparing the nums ke num with the addition of curNum + newArr[prevNum] with the newArr[curNum] as new[curNum] is the max num at any point.
                newArr[i + 1] = Math.max(newArr[i] , newArr[i - 1] + nums[i]);
            }

            return newArr[nums.length];
        }
}
