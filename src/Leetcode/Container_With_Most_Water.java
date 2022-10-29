//https://leetcode.com/problems/container-with-most-water/
package Leetcode;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

//         We have to find the max area of the container between two heights.
        while (left < right){
//             Getting width, height of every possible biggest heights.
            int width = right - left;
//             We are returning minimum height amongst the two otherwise water will overflow.
            int h = Math.min(height[left] , height[right]);
            int area = h * width;
            max = Math.max(max, area);

//             Here we are using 2 pointer and getting the possible pairs.
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }

        }
        return max;
    }
}
