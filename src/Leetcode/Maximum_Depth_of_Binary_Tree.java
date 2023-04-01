//https://leetcode.com/problems/maximum-depth-of-binary-tree/
package Leetcode;
//import java.util.*;

public class Maximum_Depth_of_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }    }

    public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            int l = maxDepth(root.left);
            int r = maxDepth(root.right);

            return 1 + Math.max(l, r);
        }
}
