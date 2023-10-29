package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Level_Sum_of_a_Binary_Tree {
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
        Integer[] parentArray = {1,7,0,7,-8,null,null};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(maxLevelSum(root));
    }

    static int maxLevelSum(TreeNode root) {
        int maxi = Integer.MIN_VALUE, lvl = 0, ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            int sum  = 0;
            lvl++;

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                sum+=top.val;

                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
            if (sum > maxi){
                maxi = sum;
                ans = lvl;
            }
        }
        return ans;
    }
}
