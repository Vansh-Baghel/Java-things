//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
package Leetcode;
import java.util.*;

public class Binary_Tree_Inorder_Traversal {
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    public static TreeNode arrayToTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);
        root.left = arrayToTree(arr, 2 * index + 1);
        root.right = arrayToTree(arr, 2 * index + 2);

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, 3}; // Replace this with your array
        TreeNode root = arrayToTree(arr, 0);

        List<Integer> ans = morrisTraversal(root);
        System.out.println(ans);
    }

    // Iterative
    static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;
        TreeNode node= root;
        while (true){
            if (node != null) {
                st.add(node);
                node = node.left;
            } else{
                if (st.isEmpty()) break;
                node=st.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

// Recursive
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inorder(root , ans);
        return ans;
    }

    public void inorder(TreeNode root , List<Integer> ans){
        if (root == null) return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;

        while (cur!=null){
            TreeNode prev = cur.left;
            if(cur.left==null){
                ans.add(cur.val);
                cur=cur.right;
            } else{
                while (prev.right!=null && prev.right!=cur){
                    prev=prev.right;
                } if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                } else{
                    prev.right=null;
                    // adding cur while marking the right thread, therefore this will print left, root, right
                    ans.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return ans;
    }
}

