//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
package Leetcode;
import java.util.*;

public class Binary_Tree_Preorder_Traversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrderPrint(root , ans);
        return ans;
    }

    public void preOrderPrint(TreeNode root, List<Integer> ans){
        if (root == null) return;
        ans.add(root.val);
        preOrderPrint(root.left, ans);
        preOrderPrint(root.right, ans);
    }
}
