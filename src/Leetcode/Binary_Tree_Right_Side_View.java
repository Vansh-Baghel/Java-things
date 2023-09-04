package Leetcode;
import java.util.*;

public class Binary_Tree_Right_Side_View {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
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
        System.out.print(root.data + "-> ");
        System.out.print(root.left == null ? "null, " : root.left.data + ", ");
        System.out.println(root.right == null ? "null" : root.right.data);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer[] parentArray = {1,2,3,null,4};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(rightSideView(root));
    }


    static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        rightDisplay(root, ans, 0);
        return ans;
    }

    static void rightDisplay(TreeNode root, ArrayList<Integer> ans, int depth) {
        if (root == null) return;

        if (depth == ans.size()){
            ans.add(root.data);
        }

        // Here depth will not be saved, since its an integer therefore even if we add it everytime, then the value which is saved will only be changed.
        if (root.right != null) rightDisplay(root.right, ans, depth + 1);
        if (root.left != null) rightDisplay(root.left, ans, depth + 1);
    }
}
