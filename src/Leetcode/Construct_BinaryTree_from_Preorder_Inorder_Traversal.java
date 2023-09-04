//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Construct_BinaryTree_from_Preorder_Inorder_Traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    public static TreeNode constructBinaryTree(Integer[] parentArray) {
        if (parentArray == null || parentArray.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(parentArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (index < parentArray.length && parentArray[index] != null) {
                current.left = new TreeNode(parentArray[index]);
                queue.add(current.left);
            }
            index++;

            if (index < parentArray.length && parentArray[index] != null) {
                current.right = new TreeNode(parentArray[index]);
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    private static void display(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + "-> ");
        System.out.print(root.left == null ? "null, " : root.left.val + ", ");
        System.out.println(root.right == null ? "null" : root.right.val);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode ans = buildTree2(pre, in);
        display(ans);
    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            hm.put(inorder[i] , i);
        }
        TreeNode root = binaryTree(preorder , 0 , preorder.length - 1, inorder, 0 , inorder.length - 1 , hm);
        return root;
    }

    static TreeNode binaryTree(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> hm) {
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

    static TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        TreeNode root = binaryTreePreAndInorder(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, hm);

        return root;
    }

    static TreeNode binaryTreePreAndInorder(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, HashMap<Integer, Integer> hm) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = hm.get(root.val);
        int numsLeft = index - inStart;

        root.left = binaryTreePreAndInorder(inorder, inStart, index-1, preorder, preStart + 1, preStart + numsLeft, hm);
        root.right = binaryTreePreAndInorder(inorder, index + 1, inEnd, preorder, preStart + numsLeft + 1, preEnd, hm);

        return root;
    }
}
