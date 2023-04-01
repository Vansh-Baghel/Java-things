//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
package Leetcode;
import java.util.*;

public class Binary_Tree_Inorder_Traversal {
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
    }

}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inorder(root , ans);
        return ans;
    }

    public void inorder(TreeNode root , List<Integer> ans){
        if (root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);

    }
}

