package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree {
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
        Integer[] parentArray = {2,null,3,null,4,null,5,null,6};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(minDepth(root));
    }

    // DFS
    static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;
        int left = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return 1 + Math.min(left, right);
    }

    // BFS
    static int minDepth2(TreeNode root) {
        int idx = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            idx++;

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();

                if (top.left == null && top.right == null) return idx;
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
        }
        return idx;
    }
}
