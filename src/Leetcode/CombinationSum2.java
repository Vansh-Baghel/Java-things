package Leetcode;
import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        combinationSum2(arr, 8);
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);

        combinationRecursion(candidates,0,target,sum,list,ans);
        return ans;
    }

    static void combinationRecursion(int[] arr, int i, int target, int sum, List<Integer> list, List<List<Integer>> ans){
        if (i > arr.length - 1 || sum >= target){
            if (sum == target){
                if (!ans.contains(list)){
                    ans.add(new ArrayList<>(list));
                    System.out.println(list);
                }
            }
            return;
        }

        list.add(arr[i]);
        sum += arr[i];
        combinationRecursion(arr,i + 1,target,sum,list,ans);

        list.remove(list.size() - 1);
        sum -= arr[i];

        combinationRecursion(arr,i + 1,target,sum,list,ans);
    }
}
