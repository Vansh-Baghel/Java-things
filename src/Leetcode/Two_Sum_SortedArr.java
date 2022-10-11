package Leetcode;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Two_Sum_SortedArr {
    public static void main(String[] args) {

    }

    static int[] twoSum(int[] numbers, int target){
        int i = 0;
        int j = numbers.length - 1;
        int[] ans = new int[2];

//         Two pointer method.
        while (i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
//              Index numbering is in 1 form , mentioned in question. Therefore adding 1.
                ans[0] = i+1;
                ans[1] = j+1;
                break;
            }
//             If the sum is smaller than we will only shift i element to right.
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
}
