package Leetcode;
import java.util.*;

public class Preorder_Traversal {
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
            Integer[] parentArray = {1,2,4,null,5};
            TreeNode root = constructBinaryTree(parentArray);
            List<Integer> ans = preorderTraversal(root);
            System.out.println(ans);
        }

        // Iterative
    static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        st.add(root);
        while (!st.isEmpty()){
            root = st.pop();
            list.add(root.val);
            if (root.right != null) st.add(root.right);
            if (root.left != null) st.add(root.left);
        }
        return list;
    }

    // Recursive
    static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    static void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        // First will add the root.
        ans.add(root.val);
        // It will reach the left, and if null, then return.
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
