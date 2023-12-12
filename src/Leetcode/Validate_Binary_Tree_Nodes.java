package Leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class Validate_Binary_Tree_Nodes {
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

    static TreeNode searchNode(TreeNode root, int p){
        if (root == null) return null;

        if (root.val == p) return root;

        TreeNode left = searchNode(root.left, p);
        if (left!=null) return left;
        TreeNode right = searchNode(root.right, p);
        return right;
    }

    public static void main(String[] args) {
        Integer[] parentArray = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = constructBinaryTree(parentArray);
        TreeNode target = searchNode(root, 5);
        int[] l = {1,-1,3,-1};
        int[] r = {2,3,-1,-1};
        int ln = l.length;
        boolean ans = validateBinaryTreeNodes(ln, l, r);
        System.out.println(ans);
    }

    static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer, Integer> parentHm = new HashMap<>();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int cnt=0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int leftC = leftChild[i];
            int node=i;
            int rightC = rightChild[i];

            if (leftC != -1) {
                adj.get(node).add(leftC);
                if (parentHm.containsKey(leftC)) return false;
                parentHm.put(leftC, node);
            }
            if (rightC != -1) {
                adj.get(node).add(rightC);
                if (parentHm.containsKey(rightC)) return false;
                parentHm.put(rightC, node);
            }
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            if (!parentHm.containsKey(i)) {
                if (root != -1) return false;

                root = i;
            }
        }

        // Means no root
        if (root == -1) return false;

        q.add(root);
        vis[0] = true;
        cnt++;

        while (!q.isEmpty()){
            int top = q.poll();

            for (int it: adj.get(top)){
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                    cnt++;
                }
            }
        }

        return cnt == n;
    }
}
