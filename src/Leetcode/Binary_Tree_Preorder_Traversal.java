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

    static List<Integer> morrisTraversal(Binary_Tree_Inorder_Traversal.TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Binary_Tree_Inorder_Traversal.TreeNode cur = root;

        while (cur!=null){
            Binary_Tree_Inorder_Traversal.TreeNode prev = cur.left;
            if(cur.left==null){
                ans.add(cur.val);
                cur=cur.right;
            } else{
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                } if(prev.right==null){
                    prev.right=cur;
                    // adding cur while marking the right thread, therefore this will print root, left, right
                    ans.add(cur.val);
                    cur=cur.left;
                } else{
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}
