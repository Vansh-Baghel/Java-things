package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Path_Sum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode constructBinaryTree(Integer[] parentArray) {
        if (parentArray == null || parentArray.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(parentArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (index < parentArray.length && parentArray[index] != null) {
                current.left = new TreeNode(parentArray[index]);
                queue.add(current.left);
            }
            index++;

            if (index < parentArray.length && parentArray[index] != null) {
                current.right = new TreeNode(parentArray[index]);
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] parentArray = {1,2};
        TreeNode root = constructBinaryTree(parentArray);

        System.out.println(hasPathSum(root, 1));
    }

    static boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPath(root, 0, targetSum);
    }

    private static boolean checkPath(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;

        sum += root.val;
        boolean left = checkPath(root.left, sum, targetSum);
        if (targetSum == sum) return true;
        boolean right = checkPath(root.right, sum, targetSum);

        return left || right;
    }
}
