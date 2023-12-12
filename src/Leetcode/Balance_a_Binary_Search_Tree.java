package Leetcode;

import java.util.*;

public class Balance_a_Binary_Search_Tree {
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
        Integer[] parentArray = {1,null,2,null,3,null,4,null,null};
        TreeNode root = constructBinaryTree(parentArray);
        display(balanceBST(root));
    }

    static TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        constructInorderList(root, inorder);

        return constructBalancedBST(inorder, 0, inorder.size() - 1);
    }

    static TreeNode constructBalancedBST(List<Integer> list, int start, int end){
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = constructBalancedBST(list, start, mid-1);
        root.right = constructBalancedBST(list, mid+1, end);

        return root;
    }

    static void constructInorderList(TreeNode root, List<Integer> inorder){
        if (root == null) return;

        constructInorderList(root.left, inorder);
        inorder.add(root.val);
        constructInorderList(root.right, inorder);
    }
}
