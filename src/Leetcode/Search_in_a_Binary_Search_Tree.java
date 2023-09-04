package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Search_in_a_Binary_Search_Tree {
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
        Integer[] parentArray = {4,2,7,1,3};
        TreeNode root = constructBinaryTree(parentArray);
        TreeNode ans = searchBST2(root, 2);
        display(ans);
    }

    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root != null && root.val > val) root = searchBST(root.left, val);
        if (root != null && root.val < val) root = searchBST(root.right, val);
        if (root != null && root.val == val) {
            return root;
        }

        return null;
    }

    static TreeNode searchBST2(TreeNode root, int val) {
        if(root == null || root.val == val) return root;
            //if the target is lesser than the root->val, then
        else if(root.val > val) return searchBST(root.left,val);
        else return searchBST(root.right, val);
    }
}
