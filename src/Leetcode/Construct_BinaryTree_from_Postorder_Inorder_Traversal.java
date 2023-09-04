//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
package Leetcode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Construct_BinaryTree_from_Postorder_Inorder_Traversal {
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

    static TreeNode buildTree2(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return binaryTreePostAndInorder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private static TreeNode binaryTreePostAndInorder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> hm) {
        if (postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = hm.get(root.val);
        // index - inStart because if we see the right side of the inorder, then their indices are big, so if we just put the index instead of index - inStart, so it will return the total number of left nodes from entire root which we dont want. We want to get the number of left nodes from the list of nodes present.
        int numsLeft = index - inStart;

        root.left = binaryTreePostAndInorder(inorder, inStart, index - 1, postorder, postStart,postStart + numsLeft - 1, hm);
        root.right = binaryTreePostAndInorder(inorder, index + 1,  inEnd, postorder, postStart + numsLeft,postEnd - 1, hm);

        return root;
    }
}
