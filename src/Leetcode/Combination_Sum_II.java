//https://leetcode.com/problems/combination-sum-ii/
package Leetcode;
import java.util.*;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        System.out.println(combinationSum2(arr , 5));
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
//        Sorting and then pushing in the function.
        Arrays.sort(candidates);
        findingCombination2(0 , candidates , target , new ArrayList<>() , ans);
        return ans;
    }

    static void findingCombination2(int index, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {
//        Base condition.
        if (target == 0){
            // Adding new list everytime so that many arrays start forming inside one array.
            ans.add(new ArrayList<>(list));
            return;
        }

//        We dont need previous numbers of the array therefore we are moving from index number of the current element to the last index .
        for (int i = index; i < arr.length; i++) {
//            Means if the
            if (i > index && arr[i] == arr[i - 1]) continue;
//            Dont need to check further numbers because if any index is greater than the target then all the further numbers will also be as its sorted array.
            if (arr[i] > target){
                break;
            }

//            Adding before it moves to the next number.
            list.add(arr[i]);
            findingCombination2(i + 1 , arr , target - arr[i] , list , ans);
//            Removing latest numbers on backtrack.
            list.remove(list.size() - 1);
        }
    }
}
