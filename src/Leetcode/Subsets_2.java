package Leetcode;
import java.util.*;

public class Subsets_2 {
    public static void main(String[] args) {
        int[] arr = {4,4,1,4,4};
        System.out.println(subsetsWithDup(arr));
    }

        static List<List<Integer>> subsetsWithDup(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            ArrayList<Integer> list = new ArrayList<>();
            List<List<Integer>> parentList = new ArrayList<>();
            subSequencesWithoutDuplicates(nums, list, parentList, 0, n);
            return parentList;
        }

    static void subSequencesWithoutDuplicates(int[] arr, List<Integer> list, List<List<Integer>> parentList , int i, int n) {
            if (i == n) {
                if (!parentList.contains(list)) parentList.add(new ArrayList<>(list));
                return;
            }

            list.add(arr[i]);
            subSequencesWithoutDuplicates(arr, list, parentList, i + 1, n);
            list.remove(list.size() - 1);

            // Using recursion here because it will go to its previous node, but as we also need "without taking" wala condition, we again need to call this.
            subSequencesWithoutDuplicates(arr, list,  parentList,i + 1, n);
        }
}
