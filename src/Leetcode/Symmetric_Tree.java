//https://leetcode.com/problems/symmetric-tree/
package Leetcode;
import java.util.*;

public class Symmetric_Tree {
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

    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricTreeCheck(root.left , root.right);
    }

    private boolean isSymmetricTreeCheck(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

//        Left ka left must be equal to right ka right and left ka right must be equal to right ka left. If these 2 conditions return true, then answer is true.
        return ((isSymmetricTreeCheck(left.left , right.right)) && (isSymmetricTreeCheck(left.right , right.left)));
    }
}
