package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leaf_Similar_Trees {
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
        Integer[] parentArray1 = {3,5,1,6,2,9,8,null,null,7,14};
        Integer[] parentArray2 = {3,5,1,6,71,4,2,null,null,null,null,null,null,9,8};
        TreeNode root1 = constructBinaryTree(parentArray1);
        TreeNode root2 = constructBinaryTree(parentArray2);

        boolean ans = leafSimilar(root1, root2);
        System.out.println(ans);
    }

    static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        getAllLeafNodes(root1, list1);
        getAllLeafNodes(root2, list2);

        return list1.equals(list2);
    }

    private static void getAllLeafNodes(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        getAllLeafNodes(root.left, list);
        getAllLeafNodes(root.right, list);
    }
}
