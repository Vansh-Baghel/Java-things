//https://leetcode.com/problems/sum-root-to-leaf-numbers/
package Leetcode;

public class SumRoot_to_LeafNumbers {
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

     public int ans;

        public int sumNumbers(TreeNode root) {
            int val = 0;

            getSum(root , val);

            return ans;
        }

        public void getSum(TreeNode root , int val ) {
    //        Need to define cur before base condition so that we dont miss the last child node.
            int cur = val * 10 + root.val;

            if (root.left == null && root.right == null) {
                ans += cur;
                return;
            }

            if( root.left != null){
                getSum(root.left , cur);
            }        if( root.right != null){
                getSum(root.right , cur);
            }

        }
}
