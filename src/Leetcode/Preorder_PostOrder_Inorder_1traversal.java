package Leetcode;

import java.util.*;

public class Preorder_PostOrder_Inorder_1traversal {
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
        Integer[] parentArray = {1,2,3,null, null,4,5,6,7};
        TreeNode root = constructBinaryTree(parentArray);
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        display(root);
        oneForAllTraversal(preorder, inorder, postorder, root);
        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    public static class Pair{
        TreeNode st;
        int num;

        Pair(TreeNode st, int num){
            this.st = st;
            this.num=num;
        }
    }

    static void oneForAllTraversal(List<Integer> preorder, List<Integer> inorder, List<Integer> postorder, TreeNode root){
        Stack<Pair> st = new Stack<>();
        st.add(new Pair(root, 1));

        while (!st.isEmpty()){
            Pair top = st.pop();
            if (top.num == 1){
                preorder.add(top.st.val);
                top.num += 1;
                st.add(top);
                if (top.st.left != null) st.add(new Pair(top.st.left, 1));
            } else if (top.num == 2){
                inorder.add(top.st.val);
                top.num += 1;
                st.add(top);
                if (top.st.right != null) st.add(new Pair(top.st.right, 1));
            } else {
                postorder.add(top.st.val);
            }
        }
    }
}