//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
package Leetcode;

import java.util.HashMap;

public class Construct_BinaryTree_from_Preorder_Inorder_Traversal {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            hm.put(inorder[i] , i);
        }
        TreeNode root = binaryTree(preorder , 0 , preorder.length - 1, inorder, 0 , inorder.length - 1 , hm);
        return root;
    }

    private TreeNode binaryTree(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> hm) {
            if (preOrderStart > preOrderEnd || inorderStart > inorderEnd){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preOrderStart]);
//            Getting the root index for inorder from hashmap by finding the element present at preorder start because it will be root.
            int inorderRootIndex = hm.get(root.val);
            int inorderLeftNumLength = inorderRootIndex - inorderStart;

//            We cannot use root + 1 for preorder start because next numbers are also roots if there exists more than one root.
            root.left = binaryTree(preorder, preOrderStart + 1 , (preOrderStart + inorderLeftNumLength) , inorder, inorderStart , inorderRootIndex - 1, hm );
//            We have inorderLeftNumLength which will determine the preorder ka starting index num.
            root.right = binaryTree(preorder, preOrderStart + inorderLeftNumLength +  1 , preOrderEnd , inorder, inorderRootIndex + 1 , inorderEnd, hm );

            return root;
        }
}
