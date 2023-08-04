package Leetcode;
import java.util.*;

public class PermutationsRevise {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = permute(arr);

        System.out.println(ans);
    }

    static List<List<Integer>> permute(int[] nums) {
        int[] vis = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        permuteRecursion(nums, vis, list, ans);

        return ans;
    }

    static void permuteRecursion(int[] nums, int[] vis, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 0){
                vis[i] = 1;
                list.add(nums[i]);

                permuteRecursion(nums, vis, list, ans);

                vis[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
