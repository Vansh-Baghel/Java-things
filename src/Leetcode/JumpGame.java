//https://leetcode.com/problems/jump-game/
package Leetcode;
import java.util.*;

public class JumpGame {
        public boolean canJump(int[] nums) {
            int max= 0;
//            till second last index bcoz we dont need to check the last index as that is the index we want to reach.
            for (int i = 0; i < nums.length - 1 && max >= i; i++) {
                if (max < i + nums[i]){
//            if at any index the max value exceeds the length of the nums, it means we got the answer.
                    max = i + nums[i];
                }
                if (max >= nums.length - 1){
                    return true;
                }
            }
            return false;
        }
}
