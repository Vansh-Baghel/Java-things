package Leetcode;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        combinationSum(candidates, target);
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        combinationRecursion(candidates,0,target,sum,list,ans);

        return ans;
    }

    static void combinationRecursion(int[] arr, int i, int target, int sum, List<Integer> list, List<List<Integer>> ans){
        if (i > arr.length - 1 || sum >= target){
            if (sum == target){
                ans.add(list);
                System.out.println(list);
            }
            return;
        }

        list.add(arr[i]);
        sum += arr[i];
        combinationRecursion(arr,i,target,sum,list,ans);

        list.remove(list.size() - 1);
        sum -= arr[i];

        combinationRecursion(arr,i + 1,target,sum,list,ans);
    }
}
