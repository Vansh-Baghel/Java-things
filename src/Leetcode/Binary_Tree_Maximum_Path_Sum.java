package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Maximum_Path_Sum {
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

    static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode _node, int _index) {
            index = _index;
            node = _node;
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
        Integer[] parentArray = {1,3,2,5,3,null,9};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(maxPathSum(root));
    }

    static int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;

        maxSum(root, max);
        return max[0];
    }

    static int maxSum(TreeNode root, int[] max) {
        if (root == null) return 0;
        TreeNode node = root;
        int left = Math.max(0 ,maxSum(node.left, max));
        int right = Math.max(0 ,maxSum(node.right, max));
        max[0] = Math.max(left+right+ node.val , max[0]);
        return node.val + Math.max(left, right);
    }
}
