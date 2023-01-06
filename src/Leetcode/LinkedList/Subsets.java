//https://leetcode.com/problems/subsets/
package Leetcode.LinkedList;
import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getAns(nums, 0, list, ans);
        return ans;
    }

    private void getAns(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        getAns(nums , index + 1 , list , ans);
        list.remove(list.size() - 1);
        getAns(nums , index + 1 , list , ans);
        }
    }

