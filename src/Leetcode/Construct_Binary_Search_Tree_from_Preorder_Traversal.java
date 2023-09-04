package Leetcode;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
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
        int[] parentArray = {8, 5, 1, 7, 10, 12};

        TreeNode ans = bstFromPreorder(parentArray);
        display(ans);
    }


    static TreeNode bstFromPreorder(int[] preorder) {
        return createPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    static TreeNode createPreorder(int[] preorder, int max, int[] i) {
        if(i[0] == preorder.length || preorder[i[0]] > max) return null;

        TreeNode root= new TreeNode(preorder[i[0]++]);
        root.left = createPreorder(preorder, root.val, i);
        root.right = createPreorder(preorder, max, i);
        return root;
    }
}
