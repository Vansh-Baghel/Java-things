//https://leetcode.com/problems/combination-sum-ii/
package Leetcode;
import java.util.*;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2_3(arr , 8));
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


    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getAllCombinations(candidates, ans, list, target, 0);
        return ans;
    }

    private void getAllCombinations(int[] candidates, List<List<Integer>> ans, List<Integer> list, int target, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == candidates[i + 1]) {
                continue;
            }

            if (target == 0) {
                ans.add(new ArrayList<>(list));
                break;
            }

            if (target < 0) break;

            list.add(candidates[i]);
            getAllCombinations(candidates, ans, list, target - candidates[i], i+1);
            list.remove(list.size() - 1);
        }
    }










    static List<List<Integer>> combinationSum2_3(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;

        Arrays.sort(candidates);
        getAllCombinations(0, n, target, list, ans, candidates);

//        System.out.println(ans);
        return ans;
    }

    static void getAllCombinations(int idx, int n, int target, List<Integer> list, List<List<Integer>> ans, int[] candidates) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (target < 0) break;

            // i > idx means for the first index of the loop. It shouldn't matter for that.
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            list.add(candidates[i]);
            getAllCombinations(i + 1, n, target - candidates[i], list, ans, candidates);
            list.remove(list.size() - 1);
        }
    }
}
