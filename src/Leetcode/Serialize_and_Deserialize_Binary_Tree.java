package Leetcode;

import java.util.*;

public class Serialize_and_Deserialize_Binary_Tree {
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
        Integer[] parentArray = {1,2,3,null,null,4,5};
        TreeNode root = constructBinaryTree(parentArray);
        display(root);
        String ans = serialize(root);
        System.out.println(ans);
    }

    // Encodes a tree to a single string.
    static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        // Condition where there are no nodes.
        if (root == null) return str.toString();

        q.add(root);

        while (!q.isEmpty()){
            // The size will run the loop that number of times, so each level ke nodes will be stored.
                TreeNode node = q.poll();
                if (node == null) {
                    str.append("n ");
                } else {
                // Adding the root ka left and right into the queue.
                q.add(node.left);
                q.add(node.right);
                str.append(node.val+ " ");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        String[] strArr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        for (int i = 1; i < strArr.length; i++) {
            TreeNode cur = q.poll();
            if (!strArr[i].equals( "n")){
                cur.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(cur.left);
            }
            i++;
            if (!strArr[i].equals( "n")){
                cur.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(cur.right);
            }
        }

        return root;
    }
}
