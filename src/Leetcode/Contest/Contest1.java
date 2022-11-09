package Leetcode.Contest;

public class Contest1 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10};
        System.out.println(averageValue(nums));
    }

    static int averageValue(int[] nums) {
        int s = 0;
        int count = 0;
        int e = nums.length - 1;
        int sum = 0;
        int mid = s + (e-s)/2;
        while (s <= mid){
            if (nums[s] % 2== 0 && nums[s] % 3 == 0){
                sum += nums[s];
                count++;
            }
            s++;
        }
        while (e > mid){
            if (nums[e] % 2== 0 && nums[e] % 3 == 0){
                sum += nums[e];
                count++;
            }
            e--;
        }

        return count == 0 ? sum : sum / count;
    }
}
