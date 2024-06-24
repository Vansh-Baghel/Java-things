package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Smallest_String_Starting_From_Leaf {
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

    public static void main(String[] args) {
        Integer[] parentArray = {3,9,20,null,null,15,7};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(smallestFromLeaf(root));
    }

    static StringBuilder res = new StringBuilder("{");

    public static String smallestFromLeaf(TreeNode root) {
        String tmp = "";
        dfs(root, tmp);
        return res.toString();
    }

    public static void dfs(TreeNode root, String tmp){
        if (root == null) return;

        tmp += (char)(root.val + 'a');
        dfs(root.left, tmp);
        dfs(root.right, tmp);

        if (root.left == null && root.right == null) {
            tmp = reverseString(tmp);
            int compare = tmp.compareTo(res.toString());
            // Current path is smaller than res, means we found a smaller string.
            if (compare < 0) {
                res = new StringBuilder(tmp);
            }
        }
    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

        return new String(charArray);
    }
}
