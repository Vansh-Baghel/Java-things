package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Diameter_of_Binary_Tree {
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
        System.out.println(diameterOfBinaryTree(root));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        diameter(root, d);
        return d[0];
    }

    private static int diameter(TreeNode root, int[] d) {
        if (root == null) return 0;

        int left = diameter(root.left, d);
        int right = diameter(root.right, d);

        d[0] = Math.max(d[0], left+right+1);

        return 1 + Math.max(left,right);
    }
}
