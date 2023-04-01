package Leetcode.Contest;

public class Max_Count {

        public int maximumCount(int[] nums) {
            int mid = 0;    int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    mid = i;
                    break;
                }
            }
            for (int i = 0; i < mid; i++) {
                count1++;
            }
            for (int i = mid; i < nums.length; i++) {
                if (nums[i] == 0){
                    continue;
                }
                count2++;
            }
            if (count1 > count2){
                return count1;
            }
             return count2;
        }
}
