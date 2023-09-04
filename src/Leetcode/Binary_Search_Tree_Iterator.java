package Leetcode;

import java.util.Stack;

public class Binary_Search_Tree_Iterator{
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

    // TreeNode type of stack
    static Stack<TreeNode> st = new Stack<>();

    static void addAllLeft(TreeNode root, Stack<TreeNode> st){
        while (root != null) {
            st.add(root);
            root=root.left;
        };
    }

    public void BSTIterator(TreeNode root) {
        // constructor
        addAllLeft(root, st);
    }

    public int next() {
        TreeNode top = st.pop();
        if (top.right != null){
            addAllLeft(top.right, st);
        }
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
