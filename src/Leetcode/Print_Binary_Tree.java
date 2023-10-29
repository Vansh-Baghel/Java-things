package Leetcode;

import java.util.*;

public class Print_Binary_Tree {
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
        Integer[] parentArray = {1,2,3,null,4};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(printTree(root));
    }

    static List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();

        int height = findHeight(root);
        int width = (int)Math.pow(2,height)-1;
        List<String> row = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            row.add("");
        }

        for (int i = 0; i < height; i++) {
            ans.add(new ArrayList<>(row));
        }

        putNumber(root, ans, 0, height, 0, width);

        return ans;
    }

    // O(N)^2 solution
    static void putNumber(TreeNode root, List<List<String>> ans, int i, int height, int left, int right) {
        if (i > height || root == null) return;
        int mid = (left + right) / 2;

        ans.get(i).set(mid, "" + root.val);

        putNumber(root.left, ans, i + 1, height, left, mid - 1);
        putNumber(root.right, ans, i + 1, height, mid + 1, right);
    }

    static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1 + Math.max(left, right);
    }

    // O(N) solution
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) return null;

        return root;
     }
}
