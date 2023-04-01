//https://leetcode.com/problems/binary-tree-postorder-traversal/
package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(Binary_Tree_Inorder_Traversal.TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postOrderPrint(root , ans);
        return ans;
    }

    private void postOrderPrint(Binary_Tree_Inorder_Traversal.TreeNode root, List<Integer> ans) {
        if (root == null) return;

        postOrderPrint(root.left , ans);
        postOrderPrint(root.right , ans);
        ans.add(root.val);
    }
}
