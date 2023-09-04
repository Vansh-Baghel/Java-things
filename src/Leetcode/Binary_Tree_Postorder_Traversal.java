//https://leetcode.com/problems/binary-tree-postorder-traversal/
package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {
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
        Integer[] parentArray = {1,null,2,3};
        TreeNode root = constructBinaryTree(parentArray);
        display(root);
        List<Integer> ans = postorderTraversal2(root);
        System.out.println(ans);
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postOrderPrint(root , ans);
        return ans;
    }

    static void postOrderPrint(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        postOrderPrint(root.left , ans);
        postOrderPrint(root.right , ans);
        ans.add(root.val);
    }

    // using 2 stacks.
    static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        TreeNode node = root;

        // We are adding the nodes as root, left, right in the st1, and taking out the peek and adding it in the st2. So once the root is adding in the st2, its right will be added and then right node ka left and right will be checked and so on.
        // This will give us the reversed order in the st2.
        while(!st1.isEmpty()){
            node = st1.pop();
            st2.add(node);
            if (node.left != null) st1.add(node.left);
            if (node.right != null) st1.add(node.right);
        }

        while (!st2.isEmpty()) ans.add(st2.pop().val);
        return ans;
    }

    // using 1 stacks.
    static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node= root;

        while (node != null || !st.isEmpty()){
            // Adding all the left nodes first
            if (node != null){
                st.add(node);
                node=node.left;
            } else{
                // Then checking if the left node ka right exists or not. If it does, then rechecking its left. And if its left doesn't exist, we need to add the peek into the ans list.
                TreeNode temp = st.peek().right;
                if (temp != null){
                    node=temp;
                } else{
                    temp = st.pop();
                    ans.add(temp.val);
                    // Checking if the top ka right is the temp. If yes, then keep adding into the stack.
                    while (!st.isEmpty() && st.peek().right == temp) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }
            }
        }

        return ans;
    }
}
