package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Product_of_Splitted_Binary_Tree {
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
        Integer[] parentArray1 = {1,2,3,4,5,6};
        TreeNode root = constructBinaryTree(parentArray1);

        int ans = maxProduct(root);
        System.out.println(ans);
    }

    static int maxProduct(TreeNode root) {
        int totalSum = findTotalSum(root);

        int[] maxProduct = new int[1];

        findMaxProduct(root, totalSum, maxProduct);

        return maxProduct[0] % (int)(1e9 + 7);
    }

    private static int findMaxProduct(TreeNode root, int totalSum, int[] maxProduct) {
        if (root == null) return 0;

        int left = findMaxProduct(root.left,totalSum, maxProduct);
        int right = findMaxProduct(root.right,totalSum, maxProduct);

        int curSum = root.val + left + right;
        int remainingSum = totalSum - (curSum);

        maxProduct[0] = Math.max(maxProduct[0], remainingSum * curSum);

        return curSum;
    }

    private static int findTotalSum(TreeNode root) {
        if (root == null) return 0;

        return root.val + findTotalSum(root.left) + findTotalSum(root.right);
    }
}
