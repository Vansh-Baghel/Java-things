package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Convert_BST_to_Greater_Tree {
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
        Integer[] parentArray = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = constructBinaryTree(parentArray);
        display(convertBST(root));
    }

    static TreeNode convertBST(TreeNode root) {
        return constructGreaterTree(root, new int[]{0});
    }

    static TreeNode constructGreaterTree(TreeNode root, int[] sum){
        if (root == null) return null;

        root.right = constructGreaterTree(root.right, sum);
        sum[0]+=root.val;
        root.val = sum[0];
        root.left = constructGreaterTree(root.left, sum);

        return root;
    }
}