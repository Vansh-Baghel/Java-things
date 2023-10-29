package Leetcode;

import java.util.*;

public class Find_Leaves_of_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode constructBinaryTree(Integer[] parentArray) {
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

    public static void main(String[] args) {
        Integer[] parentArray = {1,2,3,4,5};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(findLeaves2(root));
    }

    static List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int height = findHeight(root);

        for (int i = 0; i < height; i++) {
            root = addLeafNodes(root, list);
            ans.add(list);
            list=new ArrayList<>();
        }

        return ans;
    }

    private static TreeNode addLeafNodes(TreeNode root, List<Integer> list) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }

        root.left = addLeafNodes(root.left, list);
        root.right = addLeafNodes(root.right, list);

        return root;
    }

    static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1 + Math.max(left, right);
    }

    static List<List<Integer>> findLeaves2(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            ans.add(new ArrayList<>());
        }

        addLeafNodes2(root, ans);

        return ans;
    }

    private static int addLeafNodes2(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return 0;

        int left = addLeafNodes2(root.left, ans);
        int right = addLeafNodes2(root.right, ans);
        int height = 1 + Math.max(left, right);

        ans.get(height).add(root.val);

        return height;
    }
}
