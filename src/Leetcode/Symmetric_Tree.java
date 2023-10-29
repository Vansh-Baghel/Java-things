//https://leetcode.com/problems/symmetric-tree/
package Leetcode;
import java.util.*;

public class Symmetric_Tree {
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
        Integer[] parentArray = {1,2,2,3,4,4,3};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(isSymmetric2(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricTreeCheck(root.left , root.right);
    }

    private boolean isSymmetricTreeCheck(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;

//        Left ka left must be equal to right ka right and left ka right must be equal to right ka left. If these 2 conditions return true, then answer is true.
        return ((isSymmetricTreeCheck(left.left , right.right)) && (isSymmetricTreeCheck(left.right , right.left)));
    }


    static boolean isSymmetric2(TreeNode root) {
        return root == null || isSymmetricCheck2(root.left, root.right);
    }

    private static boolean isSymmetricCheck2(TreeNode left, TreeNode right) {
        // if both check kiya then agar koi ek null hoga toh node.val false hojayega.
        // Therefore use OR rather than AND, and then make its return value as bool.
        if (left == null || right == null) return left == right;

        if (left.val != right.val) return false;

        return isSymmetricCheck2(left.left, right.right) && isSymmetricCheck2(left.right, right.left);
    }

    static boolean isSymmetric3(TreeNode root){
        if (root == null) return true;
        return isBothSymmetric(root.left, root.right);
    }

    private static boolean isBothSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        return isBothSymmetric( left.left, right.right) && isBothSymmetric( left.right, right.left);
    }
}
