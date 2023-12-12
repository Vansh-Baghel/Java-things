package Leetcode;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum2(candidates, target);
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        combinationRecursion(candidates, 0, target, sum, list, ans);

        return ans;
    }

    static void combinationRecursion(int[] arr, int i, int target, int sum, List<Integer> list, List<List<Integer>> ans) {
        if (i > arr.length - 1 || sum >= target) {
            if (sum == target) {
                ans.add(list);
                System.out.println(list);
            }
            return;
        }

        list.add(arr[i]);
        sum += arr[i];
        combinationRecursion(arr, i, target, sum, list, ans);

        list.remove(list.size() - 1);
        sum -= arr[i];

        combinationRecursion(arr, i + 1, target, sum, list, ans);
    }



























    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;

        getAllCombinations(0, n, target, list, ans, candidates);

//        System.out.println(ans);
        return ans;
    }

    static void getAllCombinations(int idx, int n, int target, List<Integer> list, List<List<Integer>> ans, int[] candidates) {
        if (idx >= n || target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[idx]);

        getAllCombinations(idx, n, target-candidates[idx], list, ans, candidates);

        list.remove(list.size() - 1);

        getAllCombinations(idx+1, n, target, list, ans, candidates);
    }
}
