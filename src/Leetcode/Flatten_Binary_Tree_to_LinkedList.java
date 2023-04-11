package Leetcode;

import java.util.List;

public class Flatten_Binary_Tree_to_LinkedList {
    public class TreeNode {
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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

//        Traversing full right side list.
        flatten(root.right);

//        Traversing the left most side list.
        flatten(root.left);

//        In the end of right side, its value would be null on both left and right as prev is initially null and left is anyways null.
//        Then, while traversing back, root ka right would be prev and now prev is pointing to the last number of the list.
//        Therefore last number would be attached to root's right and left would be null. Now current root would become prev and so on.
        root.right = prev;
        root.left = null;

//        Assigning current root as prev so that for next backtracking, it could be attached to the right side.
        prev = root;
    }
}
