//https://leetcode.com/problems/count-complete-tree-nodes/
package Leetcode;

public class Count_Complete_TreeNodes {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
    // O (N) complexity
    // int count = 0;

    // public int countNodes(TreeNode root) {
    //     int ans = inorder(root);

    //     return ans;
    // }

    // private int inorder(TreeNode root) {
    //     if (root == null) return 0;
    //     count++;
    //     inorder(root.left);
    //     inorder(root.right);
    //     return count;
    // }

    // O(log N) complexity
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftCount = 1;
        TreeNode l = root.left;
        while(l!=null){
            l = l.left;
            leftCount++;
        }
        int rightCount = 1;
        TreeNode r = root.right;
        while(r!=null){
            r = r.right;
            rightCount++;
        }
        if(rightCount == leftCount){
            return(int) Math.pow(2 , leftCount) - 1;
        }


        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
