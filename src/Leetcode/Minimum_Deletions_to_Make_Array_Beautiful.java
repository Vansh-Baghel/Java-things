package Leetcode;

import java.util.Stack;

public class Minimum_Deletions_to_Make_Array_Beautiful {
    public int minDeletion(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int num: nums) {
//            We can push for all even index because its said that only even num k aage wala num must not be equal to it.
            if (stack.size() % 2 == 0){
                stack.push(num);
            }
            else if (stack.peek() == num){
                // There's no point to pop here because we are neither pushing anything in this step.
                count++;
            }
            else{
                stack.push(num);
            }
        }

        // if stack ka length is odd then we just would be removing one element to make it even, therefore just return the incremented count.
        return stack.size() % 2 == 0 ? count : count + 1;
    }
}
