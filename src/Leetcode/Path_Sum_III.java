package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Path_Sum_III {
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

    private static void display(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + "-> ");
        System.out.print(root.left == null ? "null, " : root.left.val + ", ");
        System.out.println(root.right == null ? "null" : root.right.val);
        display(root.left);
        display(root.right);
    }


    public static void main(String[] args) {
        Integer[] parentArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(pathSum(root, 8));
    }

    static int totalPaths = 0;
    static int mod = 1000000007;

    static int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put((long)0, 1);
        totalSumWithPath(root, targetSum, 0, hm);
        return totalPaths;
    }

    static void totalSumWithPath(TreeNode root, int target, int sum, HashMap<Long, Integer> hm){
        if (root == null) return;

        sum += root.val;
        totalPaths = (totalPaths + hm.getOrDefault((long)sum - target, 0));
        hm.put((long)sum, hm.getOrDefault((long)sum, 0) + 1);

        totalSumWithPath(root.left, target, sum, hm);
        totalSumWithPath(root.right, target, sum, hm);
        hm.put((long)sum, hm.getOrDefault((long)sum, 0) - 1);
    }
}
