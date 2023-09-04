package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Recover_Binary_Search_Tree {
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
        Integer[] parentArray = {1,3,null,null,2};
        TreeNode root = constructBinaryTree(parentArray);
        recoverTree(root);
        display(root);
    }

    static TreeNode prev, left, middle, right = null;

    static void recoverTree(TreeNode root) {
        if (root == null) return;

        inorder(root);

        if(left != null && right != null){
            swap(left, right);
        } else if (left != null && middle != null) {
            swap(left, middle);
        }
    }

    private static void swap(TreeNode val, TreeNode val1) {
        int temp = val.val;
        val.val = val1.val;
        val1.val = temp;
    }

    static void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val){
            if (left == null) {
                left = prev;
                middle = root;
            } else right = root;
        }

        prev=root;
        inorder(root.right);
    }
}
