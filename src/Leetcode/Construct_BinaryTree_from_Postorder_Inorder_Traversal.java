//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
package Leetcode;
import java.util.HashMap;

public class Construct_BinaryTree_from_Postorder_Inorder_Traversal {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            hm.put(inorder[i] , i);
        }
        TreeNode root = binaryTree(postorder , 0 , postorder.length - 1, inorder, 0 , inorder.length - 1 , hm);
        return root;
    }

    private TreeNode binaryTree(int[] postorder, int postOrderStart, int postOrderEnd, int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> hm) {
        if (postOrderStart > postOrderEnd || inorderStart > inorderEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postOrderEnd]);
        int inorderRootIndex = hm.get(root.val);
        int inorderLeftNumLength = inorderRootIndex - inorderStart;

        root.left = binaryTree(postorder, postOrderStart , postOrderStart + inorderLeftNumLength - 1 , inorder, inorderStart , inorderRootIndex - 1, hm );
        root.right = binaryTree(postorder, inorderLeftNumLength + postOrderStart , postOrderEnd - 1 , inorder, inorderRootIndex + 1 , inorderEnd, hm );

        return root;
    }
}
