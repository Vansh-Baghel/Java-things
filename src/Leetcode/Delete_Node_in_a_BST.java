package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Delete_Node_in_a_BST {
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
        Integer[] parentArray = {5,3,6,2,4,null,7};
        TreeNode root = constructBinaryTree(parentArray);
        TreeNode ans = deleteNode(root, 5);
        display(ans);
    }

    static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        if (cur == null) return cur;
        // If root itself is to be deleted, then run this
        if (cur.val == key) return deleteThisNode(cur);

        while (true){
            if (cur == null) return root;
            if (cur.val > key) {
                if (cur.left != null && cur.left.val == key){
                    // deleteThisNode will return all the nodes, except the one to be deleted.
                    cur.left = deleteThisNode(cur.left);
                    break;
                } cur = cur.left;
            }
            else {
                if (cur.right != null && cur.right.val == key){
                    cur.right = deleteThisNode(cur.right);
                    break;
                } cur = cur.right;
            }
        }
        return root;
    }

    private static TreeNode deleteThisNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            // Attaching the root ka right with the left k rightmost node. This could have been written in easier way but that wouldn't work if we remove the very first ie root node.

            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private static TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}
