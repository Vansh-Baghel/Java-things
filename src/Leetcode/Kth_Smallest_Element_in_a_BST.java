package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Kth_Smallest_Element_in_a_BST {
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
        Integer[] parentArray = {5,3,6,2,4,null,null,1};
        TreeNode root = constructBinaryTree(parentArray);
        int ans = kthSmallest(root, 1);
        System.out.println(ans);
    }

    public static int kthSmallest(TreeNode root, int k) {
        TreeNode small=recursionInorder(root,new int[]{k});
        return small.val;
    }

    static TreeNode recursionInorder(TreeNode root,int k[]){
        if(root==null)
            return null;

        TreeNode left=recursionInorder(root.left,k);
        if(left!=null)
            return left;
        k[0]--;
        if(k[0]==0)
            return root;

        return recursionInorder(root.right,k);
    }

    static int morrisTraversalInorder(TreeNode root, int k) {
        TreeNode cur = root;
        int count = 0;

        while (cur!=null && count < k){
            TreeNode prev = cur.left;
            if(cur.left==null){
                count++;
                if (count == k) break;
                cur=cur.right;
            } else{
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                } if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                } else{
                    count++;
                    if (count == k) break;
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
        return cur.val;
    }


}
