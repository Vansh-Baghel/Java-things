package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Add_One_Row_to_Tree {
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
        Integer[] parentArray = {4,2,null,3,1};
        TreeNode root = constructBinaryTree(parentArray);

        TreeNode ans = addOneRow(root, 1, 3);
        display(ans);
    }

    // BFS
    static TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> q = new LinkedList<>();

        if (depth == 1){
            TreeNode addRoot = new TreeNode(val);
            addRoot.left = root;
            return addRoot;
        }

        int curDepth = 0;
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();
            curDepth++;

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();

                if (curDepth == depth - 1){
                    TreeNode curLeft = top.left;
                    TreeNode curRight = top.right;

                    top.left = new TreeNode(val);
                    top.right = new TreeNode(val);

                    top.left.left = curLeft;
                    top.right.right = curRight;
                } else {
                    if (top.left != null) q.add(top.left);
                    if (top.right != null) q.add(top.right);
                }
            }
        }
        return root;
    }

    // DFS
    static TreeNode addOneRow2(TreeNode root, int val, int depth) {
        int curDepth = 1;

        if (depth == 1){
            TreeNode addRoot = new TreeNode(val);
            addRoot.left = root;
            return addRoot;
        }

        createNewTree(root,val,curDepth,depth);

        return root;
    }

    private static void createNewTree(TreeNode root, int val, int curDepth, int depth) {
        if (root == null) return;

        if (curDepth == depth - 1){
            TreeNode curLeft = root.left;
            TreeNode curRight = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = curLeft;
            root.right.right = curRight;

            return;
        }

        createNewTree(root.left, val, curDepth + 1, depth);
        createNewTree(root.right, val, curDepth + 1, depth);
    }
}
