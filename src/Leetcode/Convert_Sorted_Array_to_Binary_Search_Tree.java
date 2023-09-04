package Leetcode;
import java.util.*;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);

        constructTree(root, nums, 0, nums.length - 1);

        return root;
    }

    private static void constructTree(TreeNode root, int[] nums, int s, int e) {
        if (s > e) return;

        int mid = s + (e-s) / 2;

        if (nums[mid] > root.val){
            root.right = new TreeNode(nums[s]);
        } else root.left = new TreeNode(nums[s]);

        constructTree(root, nums, s, mid - 1);
        constructTree(root, nums, mid + 1, e);
    }
}
