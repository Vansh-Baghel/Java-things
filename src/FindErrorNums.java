import java.util.Arrays;
//https://leetcode.com/problems/set-mismatch/submissions/
public class FindErrorNums {
    public static void main(String[] args) {
        // To find the index of the element.
        int[] nums = {1,2,3,3};
        findErrorNums(nums);
        System.out.print(Arrays.toString(findErrorNums(nums)));
    }
        static int[] findErrorNums(int[] nums) {
            int i = 0;

            while (i < nums.length){
                int correctIndex = nums[i] - 1;

                if (nums[correctIndex] != nums[i]){
                    swap (nums , i , correctIndex);
                }
                else {
                    i++;
                }
            }

            for (int j = 0 ; j < nums.length ; j++){
                if (nums[j] != j+1){
                    return new int[]{ nums[j] , j + 1 };
                }

            }
            return new int[] {-1,-1};
        };

        static void swap(int[] nums , int first , int second){
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }

}
