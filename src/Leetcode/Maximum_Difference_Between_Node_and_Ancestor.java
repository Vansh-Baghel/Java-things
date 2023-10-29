package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Difference_Between_Node_and_Ancestor {
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
        Integer[] parentArray1 = {3,5,1,6,2,9,8,null,null,7,14};
        TreeNode root = constructBinaryTree(parentArray1);

        int ans = maxAncestorDiff2(root);
        System.out.println(ans);
    }

    static int maxi = Integer.MIN_VALUE;
    static int mini = Integer.MIN_VALUE;
    static int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;

        findMaxDiff(root, root.left);
        findMaxDiff(root, root.right);

        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);

        return maxi;
    }

    private static void findMaxDiff(TreeNode root, TreeNode child) {
        if (child == null) return;

        maxi = Math.max(maxi, Math.abs(root.val - child.val));

        findMaxDiff(root,child.left);
        findMaxDiff(root,child.right);
    }

    static int maxAncestorDiff2(TreeNode root) {
        return findMaxDiff2(root, root.val, root.val);
    }

    static int findMaxDiff2(TreeNode root, int minValue, int maxValue) {
        if (root == null) return Math.abs(minValue - maxValue);

        minValue = Math.min(minValue, root.val);
        maxValue = Math.max(maxValue, root.val);

        int left = findMaxDiff2(root.left,minValue,maxValue);
        int right = findMaxDiff2(root.right,minValue,maxValue);

        return Math.max(left, right);
    }
}
