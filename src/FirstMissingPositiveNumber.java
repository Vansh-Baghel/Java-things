import java.util.*;

public class FirstMissingPositiveNumber {
    public static void main(String[] args) {
        int[] a = {3,4,1,-1};
        System.out.println(firstMissingPositive(a));
    }

    static int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length){
            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] < nums.length && nums[correctIndex] != nums[i]){
                swap (nums , i , correctIndex);
            }
            else {
                i++;
            }
        }

        for (int j = 0 ; j < nums.length ; j++){
            if (nums[j] != j+1){
                return j+1;
            }
        }
        // Returning length + 1 because if the array is of {1} then they want the missing number as 2. And if the last number is missing in any array
        // then j+1 can handle it .
        return nums.length + 1;
    };

    static void swap(int[] nums , int first , int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
