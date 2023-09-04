package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximum_Width_of_Binary_Tree {
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

    static class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode _node, int _index) {
            index = _index;
            node = _node;
        }
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
        Integer[] parentArray = {1,3,2,5,3,null,9};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(widthOfBinaryTree(root));
    }

    static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.peek().index - min;
                TreeNode node = q.peek().node;
                q.poll();

                if(i==0) first = cur;
                if(i==size-1) last = cur;

                if (node.left != null) q.add(new Pair(node.left, 2 * cur + 1));
                if (node.right != null) q.add(new Pair(node.right, 2 * cur + 2));
            }
            ans= Math.max(ans, last - first + 1);
        }
        return ans;
    }

    static int widthOfBinaryTree1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()){
            int size = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int cur = q.peek().index;
                TreeNode node = q.peek().node;
                q.poll();

                if(i==0) first = cur;
                if(i==size-1) last = cur;

                if (node.left != null) q.add(new Pair(node.left, 2 * cur + 1));
                if (node.right != null) q.add(new Pair(node.right, 2 * cur + 2));
            }
            ans= Math.max(ans, last - first + 1);
        }
        return ans;
    }

}
