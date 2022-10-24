//https://leetcode.com/problems/max-consecutive-ones/
package Leetcode;

public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {

//            This one line is simplified below .
//        max = Math.max(max , num == 0 ? 0 : num++);


//            Dont count if the number is 0 as its given condition of the question.
            if (num == 0) {
                count = 0;
            }
//            else keep increasing the count.
            else {
                count++;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
