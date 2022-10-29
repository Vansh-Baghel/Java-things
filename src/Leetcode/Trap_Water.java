//https://leetcode.com/problems/trapping-rain-water/
package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Trap_Water {
    //     https://youtu.be/KSfJoI4KT_M

    public int trap(int[] height) {
        int length = height.length;
//        creating 2 new arrays .
        int[] left = new int[length];
        int[] right = new int[length];
        int ans = 0;
//        Assigning first of left array as we are comparing left with its previous element below.
        left[0] = height[0];
//        Assigning last of right array as we are comparing right with its next element below.
        right[length - 1] = height[length - 1];

//        Water will be between blocks whose height is bigger in left and right side . Compare the left and right , get minimum among them and subtract the given array k element from it .

//        Insert the max element in left . If element in given array is greater than left then update the left array ka  element.
        for (int i = 1; i < length ; i++) {
            left[i] = Math.max(left[i - 1] , height[i]);
        }
//        Insert the max element in right . If element in given array is greater than right then update the right array ka element.
        for (int i = length - 2; i >= 0 ; i--) {
            right[i] = Math.max(right[i + 1] , height[i]);
        }
        for (int i = 0; i < length; i++) {
            ans += Math.min(left[i] , right[i]) - height[i];
        }
        return ans;
    }
}
