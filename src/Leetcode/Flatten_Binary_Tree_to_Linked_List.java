package Leetcode;

import java.util.*;

public class Flatten_Binary_Tree_to_Linked_List {
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
        Integer[] parentArray = {1,2,5,3,4,null,6};
        TreeNode root = constructBinaryTree(parentArray);
        flatten(root);
        display(root);
    }

    static void morrisFlatten(TreeNode root) {
        TreeNode cur = root;

        while (cur!=null){
            if(cur.left!=null){
                TreeNode prev = cur.left;
                while (prev.right!=null){
                    prev=prev.right;
                }
                prev.right = cur.right;
                cur.right=cur.left;
                // Making cur ka left as null always, else it will return the nodes twice. We are shifting all the nodes on right.
                cur.left = null;
            }
            // cur ka left nhi le skte, because in the case of last child, it will be null.
            cur=cur.right;
        }
    }

    // Using recursion
    static TreeNode prev = null;
    static void flatten(TreeNode root) {
        if (root == null) return;

//        Traversing full right side list.
        flatten(root.right);

//        Traversing the left most side list.
        flatten(root.left);

//        In the end of right side, its value would be null on both left and right as prev is initially null and left is anyways null.
//        Then, while traversing back, root ka right would be prev and now prev is pointing to the last number of the list.
//        Therefore last number would be attached to root's right and left would be null. Now current root would become prev and so on.
        root.right = prev;
        root.left = null;

//        Assigning current root as prev so that for next backtracking, it could be attached to the right side.
        prev = root;
    }
}
