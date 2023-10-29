package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Completeness_of_a_Binary_Tree {
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
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
        Integer[] parentArray = {1,2,3,null,null,7,8};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(isCompleteTree(root));
    }

    public static boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return dfs(root, 1, totalNodes);
    }

    private static boolean dfs(TreeNode root, int i, int totalNodesWithNull) {
        if (root == null) return true;

        if (i > totalNodesWithNull) return false;

        return dfs(root.left, 2 * i, totalNodesWithNull) && dfs(root.right, 2 * i + 1, totalNodesWithNull);
    }

    private static int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1+countNodes(root.left) + countNodes(root.right);
    }


    public boolean isCompleteTree2(TreeNode root) {
        boolean past = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();

                if (top == null) {past = true;continue;}
                else if (past) return false;

                q.add(top.left);
                q.add(top.right);
            }
        }

        return true;
    }
}
