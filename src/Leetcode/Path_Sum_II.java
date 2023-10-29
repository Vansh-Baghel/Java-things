package Leetcode;
import java.util.*;

public class Path_Sum_II {
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

    public static void main(String[] args) {
        Integer[] parentArray = {1,2};
        TreeNode root = constructBinaryTree(parentArray);

        List<List<Integer>> ans = pathSum2(root, 1);

        for (List<Integer> innerList : ans) {
            for (Integer value : innerList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println(ans);
    }

    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        addPath(root, 0, targetSum, list, ans);
        return ans;
    }

    private static void addPath(TreeNode root, int sum, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) return;

        list.add(root.val);

        if (isLeaf(root)) {
            if (targetSum == sum + root.val) {
                list.add(root.val);
                ans.add(new ArrayList<>(list));
            }
        };

        addPath(root.left, sum + root.val, targetSum, list, ans);
        addPath(root.right, sum + root.val, targetSum, list, ans);
        list.remove(list.size() - 1);
    }

    static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findTargetPath(root, targetSum, list, ans);

        return ans;
    }

    private static void findTargetPath(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) return;

        list.add(root.val);
        findTargetPath(root.left, targetSum - root.val, list, ans);
        findTargetPath(root.right, targetSum - root.val, list, ans);

        // Root to leaf is the path. targetSum == root.val because we are changing the target before moving down, there at leaf it will be the leaf ka value.
        if (root.left == null && root.right == null) if (targetSum == root.val) ans.add(new ArrayList<>(list));

        list.remove(list.size() - 1);
    }
}
