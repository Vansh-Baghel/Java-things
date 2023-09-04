package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Count_Complete_Tree_Nodes {
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
        Integer[] parentArray = {1,2,3,4,5};
        TreeNode root = constructBinaryTree(parentArray);
        int ans = countNodes(root);
        System.out.println(ans);
    }

    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        int left = maxDepthLeft(root, count);
        int right = maxDepthRight(root, count);

        // Using recursion here because we need to return its count with formula.
        return left != right ? countNodes(root.left) + countNodes(root.right) + 1 : (int) Math.pow(2 , right+1) - 1;
    }

    private static int maxDepthLeft(TreeNode root, int count) {
        while (root.left != null){
            count++;
            root=root.left;
        }

        return count;
    }
    private static int maxDepthRight(TreeNode root, int count) {
        while (root.right != null){
            count++;
            root=root.right;
        }

        return count;
    }
}
