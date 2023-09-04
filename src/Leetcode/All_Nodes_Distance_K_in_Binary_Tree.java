package Leetcode;

import java.util.Arrays;
import java.util.*;

public class All_Nodes_Distance_K_in_Binary_Tree {
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
        List<Integer> ans = distanceK(root, target, 2);
        System.out.println(ans);
    }

    private static void parent_nodes_fn(TreeNode root, HashMap<TreeNode, TreeNode> parent_hm) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            TreeNode cur = q.poll();

            if (cur.left != null) {
                q.add(cur.left);
                parent_hm.put(cur.left, cur);
            }
            if (cur.right != null) {
                q.add(cur.right);
                parent_hm.put(cur.right, cur);
            }
        }
    }

    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parent_hm = new HashMap<>();
        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        List<Integer> ans= new ArrayList<>();

        parent_nodes_fn(root, parent_hm);

        int depth = 0;
        q.add(target);
        vis.put(target, true);

        while (!q.isEmpty()){
            int size = q.size();

            if (depth == k) break;
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                TreeNode par = parent_hm.get(cur);

                if (cur.left != null && vis.get(cur.left) == null){
                    q.add(cur.left);
                    vis.put(cur.left, true);
                }
                if (cur.right != null && vis.get(cur.right) == null){
                    q.add(cur.right);
                    vis.put(cur.right, true);
                }
                if (par != null && vis.get(par) == null){
                    q.add(par);
                    vis.put(par, true);
                }
            }
        }
        while(!q.isEmpty()) ans.add(q.poll().val);

        return ans;
    }
}
