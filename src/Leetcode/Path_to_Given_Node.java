package Leetcode;

import java.util.*;

public class Path_to_Given_Node {
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
        Integer[] parentArray = {15, 1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};
        TreeNode root = constructBinaryTree(parentArray);
        int[] ans = solve(root, 4);
        System.out.println(Arrays.toString(ans));
    }

    static int[] solve(TreeNode A, int B) {
        List<Integer> list = new ArrayList<>();
        getPath(A,B,list);
        int n = list.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    static boolean getPath(TreeNode root, int val, List<Integer> list) {
        if (root == null){
            return false;
        }

        // Add krna hee hai node in any case.
        list.add(root.val);

        // If this is true, then we found the answer.
        if (root.val == val){
            return true;
        }

        // If koi bhi true hua, toh rok do, and return true. Means answer mil gya.
        if (getPath(root.left, val, list) || getPath(root.right, val, list)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }
}
