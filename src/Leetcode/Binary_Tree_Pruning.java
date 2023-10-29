package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Pruning {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode constructBinaryTree(Integer[] parentArray) {
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
        Integer[] parentArray = {1,null,0,0,1};
        TreeNode root = constructBinaryTree(parentArray);
        pruneTree(root);
        display(root);
    }

    static TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        if(!isOnePresent(root.left)) {
            root.left = null;
        }

        if(!isOnePresent(root.right)) {
            root.right = null;
        }

        pruneTree(root.left);
        pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) return null;

        return root;
    }

    private static boolean isOnePresent(TreeNode root) {
        if (root == null) return false;

        if (root.val == 1) return true;

        boolean left = isOnePresent(root.left);
        boolean right = isOnePresent(root.right);

        return left || right;
    }
}
