package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Insert_into_a_Binary_Search_Tree {
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
        TreeNode ans = insertIntoBST(root, 5);
        display(ans);
    }

    static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode node = root;
        while (root!=null){
            if (node.val > val){
                if(node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                } else {
                    node=node.left;
                }
            }
            else {
                if(node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                } else {
                node=node.right;
            }
        }
    }
        return root;
}
}
