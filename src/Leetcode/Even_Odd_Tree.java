package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Even_Odd_Tree {
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
        Integer[] parentArray = {1,null,2,3};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(isEvenOddTree(root));
    }

    static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        int lvl = 0;
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            int prev = -1;

            for (int i = 0; i < size; i++){
                TreeNode top = q.poll();

                // even
                if (lvl % 2 == 0) {
                    if (top.val % 2 == 0) return false;
                    if (i == 0) {
                        prev = top.val;
                    } else {
                        if (prev < top.val) prev = top.val;
                        else return false;
                    }
                } else {
                    if (top.val % 2 != 0) return false;

                    if (i == 0) {
                        prev = top.val;
                    } else {
                        if (prev > top.val) prev = top.val;
                        else return false;
                    }
                }

                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }

            lvl++;
        }

        return true;
    }
}
