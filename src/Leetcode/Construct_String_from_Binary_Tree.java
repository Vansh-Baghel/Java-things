package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Construct_String_from_Binary_Tree {
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
        Integer[] parentArray = {1,2,3,4};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(tree2str(root));
    }

    static String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();

        if (root != null) {
            res.append(root.val);

            // Left hee print karo with brackets
            if (root.left != null && root.right == null) {
                res.append("(").append(tree2str(root.left)).append(')');
            }
            // Print empty brackets for left and then print right
            else if (root.left == null && root.right != null) {
                res.append("()(").append(tree2str(root.right)).append(')');
            }
            // If both present tab toh pura karo
            else if (root.left != null && root.right != null) {
                res.append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(')');
            }
        }

        return res.toString();
    }
}
