package Leetcode;

public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {
        int el = 0;
        int count = 0;
        for(int num: nums){
            if (count == 0){
                el = num;
            }
            if (num == el){
                ++count;
            }
            else{
                --count;
            }
        }
        return el;
    }
}
