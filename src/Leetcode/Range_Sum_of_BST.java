package Leetcode;

public class Range_Sum_of_BST {
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

    static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int ans = 0;
        ans += rangeSumBST(root.left, low, high);

        if (root.val >= low && root.val <= high) ans+=root.val;

        ans += rangeSumBST(root.right, low, high);

        return ans;
    }
}
