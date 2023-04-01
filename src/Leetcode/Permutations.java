//https://leetcode.com/problems/permutations/
package Leetcode;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(ans);
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subArr = new ArrayList<>();
//        To mark the index in the array as true if there's already a number at that index.
        boolean[] filledIndex = new boolean[nums.length];
        findAns(nums, ans, subArr , filledIndex);
        return ans;
    }

    private static void findAns(int[] nums, List<List<Integer>> ans, List<Integer> subArr, boolean[] filledIndex) {
//        Base condition is that if the subArr is completely filled, then stop the recursion.
        if (subArr.size() == nums.length){
            ans.add(new ArrayList<>(subArr));
            return;
        }
//        While backtracking, i will be 2 itself and the filledIndex will become false and when it reaches the for loop then 2nd index el will be added and then it will backtrack again which will set i = 0. Just debug and see in IntellIJ. For all i ie 0 , 1 , 2 it will run the backtrack.
        for (int i = 0; i < nums.length; i++) {
            if(!filledIndex[i]){
                subArr.add(nums[i]);
                filledIndex[i] = true;
                findAns(nums, ans, subArr , filledIndex);
                filledIndex[i] = false;
                subArr.remove(subArr.size() - 1);
            }
        }
    }
}
