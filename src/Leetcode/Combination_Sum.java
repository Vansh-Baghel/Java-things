//https://leetcode.com/problems/combination-sum/
package Leetcode;
import java.util.*;


public class Combination_Sum {
//    We are just adding and removing and not printing anything in the void method.
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr , 7));
    }
    static void findingCombination(int index, int[] arr , int target , List<Integer> list , List<List<Integer>> ans){
        if (index == arr.length){
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (target >= arr[index]){
//            Adding index because it recursion.
            list.add(arr[index]);
//            Using recursion call to call the YES part of adding , and modifying target .
            findingCombination(index , arr , target - arr[index] , list , ans);
//            During backtracking we are removing the last element which is added so that it is not present there when a new answer is formed.
            list.remove(list.size() - 1);
        }
//        Incrementing the index so once it reaches the last element of array from any number during recursion , then it meets the base condition.
        findingCombination(index + 1 , arr , target , list , ans);
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findingCombination(0 , candidates , target , new ArrayList<>() , ans);
        return ans;
    }
}
