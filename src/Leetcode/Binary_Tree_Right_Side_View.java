package Leetcode;
import java.util.*;

public class Binary_Tree_Right_Side_View {
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
        Integer[] parentArray = {1,2,3,null,4};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(rightSideView2(root));
    }


    static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rightDisplay(root, ans, 0);
        return ans;
    }

    static void rightDisplay(TreeNode root, ArrayList<Integer> ans, int depth) {
        if (root == null) return;

        if (depth == ans.size()){
            ans.add(root.val);
        }

        // Here depth will not be saved, since its an integer therefore even if we add it everytime, then the value which is saved will only be changed.
        if (root.right != null) rightDisplay(root.right, ans, depth + 1);
        if (root.left != null) rightDisplay(root.left, ans, depth + 1);
    }










    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);

                if (i == size - 1) ans.add(top.val);
            }
        }

        return ans;
    }
    public static List<Integer> rightSideView3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        getRightNodes(root, ans, 0);
        return ans;
    }

    private static void getRightNodes(TreeNode root, List<Integer> ans, int depth) {
        if (root == null) return;

        if (ans.size() < depth) ans.add(root.val);

        getRightNodes(root.right, ans, depth + 1);
        getRightNodes(root.left, ans, depth + 1);
    }
}
