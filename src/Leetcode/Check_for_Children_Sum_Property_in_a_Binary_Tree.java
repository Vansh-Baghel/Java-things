package Leetcode;

public class Check_for_Children_Sum_Property_in_a_Binary_Tree {
    class Node{
        int data;
        Node left,right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static int isSumProperty(Node root){
        return solve(root) ? 1 : 0;
    }

    static boolean solve(Node root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        if (root.left != null && root.right == null && root.data != root.left.data) return false;
        if (root.left == null && root.right != null && root.data != root.right.data) return false;
        if (root.left!=null && root.right != null && root.data != root.left.data + root.right.data) return false;

        return solve(root.left) && solve(root.right);
    }
}
