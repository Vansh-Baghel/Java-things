//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
package Leetcode;

public class Remove_Three_Dup_From_Sorted_Array {
    public static void main(String[] args) {

    }

//    https://www.youtube.com/watch?v=drbtmYjZQHQ
    static int removeDuplicates(int[] nums) {
//       e iterates the nums and i will point the position of original array where we will print the valid elements in nums .
        int e = 2;
        int i = 2;

        while (e < nums.length ){
//             If condition is true , then add the nums[e] element at position nums[i] and do e+=1 and i+=1. If false then just increase e . Once the condition becomes true after being false already , then the i element will be changes with e again.
            int ternary = nums[e] != nums[i - 2] ? nums[i++] = nums[e++] : e++;

//             Ternary is same as this .
            // if (nums[e] != nums[i - 2]){
            // nums[i++] = nums[e++];
            // }
            // else{
            //     e++;
            // }
        }
//         returning the number of valid elements .
        return i;
    }
}
