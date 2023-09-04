package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
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
        Integer[] parentArray = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = constructBinaryTree(parentArray);
        TreeNode p = searchNode(root, 6);
        TreeNode q = searchNode(root, 4);
        TreeNode ans = lowestCommonAncestor2(root, p, q);
        System.out.println(ans.val);
    }

    static TreeNode searchNode(TreeNode root, int p){
        if (root == null) return null;

        if (root.val == p) return root;

        TreeNode left = searchNode(root.left, p);
        if (left!=null) return left;
        TreeNode right = searchNode(root.right, p);
        return right;
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.left == p && root.right == q) return root;

        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (right == null) return left;
        if (left == null) return right;

        return root;
    }

    static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        if (left != null && left != p && left != q) return left;
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) return root;
        return right == null ? left : right;
    }
}
