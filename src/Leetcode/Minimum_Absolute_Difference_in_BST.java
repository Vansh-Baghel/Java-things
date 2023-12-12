package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Minimum_Absolute_Difference_in_BST {
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
        Integer[] parentArray = {1,null,2,null,3,null,4,null,null};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(getMinimumDifference(root));
    }

    static int getMinimumDifference(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        int mini = Integer.MAX_VALUE;

        constructInorder(root, inorder);

        for (int i = 1; i < inorder.size(); i++) {
            mini = Math.min(mini, inorder.get(i) - inorder.get(i-1));
        }
        return mini;
    }

    static void constructInorder(TreeNode root, List<Integer> inorder){
        if (root == null) return;

        constructInorder(root.left, inorder);
        inorder.add(root.val);
        constructInorder(root.right, inorder);
    }
}