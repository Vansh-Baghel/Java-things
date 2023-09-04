package Leetcode;

import java.util.Stack;

public class Two_Sum_IV_Input_is_a_BST {

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

    public class BSTIterator{
        static Stack<TreeNode> st = new Stack<>();
        static boolean reverse = true;
        static void addAll(TreeNode root){
            while (root != null) {
                st.add(root);
                if (reverse) root=root.right;
                else root=root.left;
            }
        }

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            addAll(root);
        }

        public int next() {
            TreeNode top = st.pop();
            if (!reverse) addAll(top.right);
            else addAll(top.left);
            return top.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

    }
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int leftVal = l.next();
        int rightVal = r.next();

        while (leftVal < rightVal){
            if (leftVal + rightVal == k) return true;
            else if (leftVal + rightVal > k) leftVal = l.next();
            else rightVal = r.next();
        }

        return false;
    }
}
