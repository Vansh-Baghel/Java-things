package Leetcode;

import java.util.*;

public class Delete_Nodes_And_Return_Forest {
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
        Integer[] parentArray = {1,2,3};
        int[] arr={3,5};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(delNodes(root, arr));
    }

    static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> hs = new HashSet<>();
        List<TreeNode> ans = new ArrayList<>();

        for (int num : to_delete) {
            hs.add(num);
        }

        formNodes(root, ans, hs);

        if(!hs.contains(root.val)){
            ans.add(root);
        }

        return ans;
    }

    private static TreeNode formNodes(TreeNode root, List<TreeNode> ans, HashSet<Integer> hs) {
        if(root == null) return null;

        root.left = formNodes(root.left, ans, hs);
        root.right = formNodes(root.right, ans, hs);

        if (hs.contains(root.val)){
            if (root.left != null) ans.add(root.left);
            if (root.right != null) ans.add(root.right);
            return null;
        } else return root;
    }
}
