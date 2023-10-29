package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
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
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        TreeNode root = buildTree(a, b);
        display(root);
    }

    static HashMap<Integer, Integer> hm = new HashMap<>();

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0, inStart = 0, preEnd = preorder.length, inEnd = inorder.length;

        for (int i = 0; i < inEnd; i++) {
            hm.put(inorder[i], i);
        }

        return createBinaryTree(preorder, inorder, preStart, preEnd - 1, inStart, inEnd - 1);
    }

    static TreeNode createBinaryTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIdx = hm.get(root.val);
        int leftInorderSize = rootIdx - inStart;
        root.left = createBinaryTree(preorder, inorder, preStart + 1, preStart + leftInorderSize, inStart, rootIdx - 1);
        root.right = createBinaryTree(preorder, inorder, preStart + leftInorderSize + 1, preEnd, rootIdx + 1,  inEnd);

        return root;
    }
}
