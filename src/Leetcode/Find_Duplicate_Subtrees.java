package Leetcode;

import java.util.*;

public class Find_Duplicate_Subtrees {
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
        Integer[] parentArray1 = {1,2,3,4,null,2,4,null,null,4};
        TreeNode root = constructBinaryTree(parentArray1);

        List<TreeNode> ans = findDuplicateSubtrees(root);
        System.out.println(ans);
    }
    static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        subtrees(root, hm, ans);

        return ans;
    }

    private static String subtrees(TreeNode root, HashMap<String, Integer> hm, List<TreeNode> ans) {
        if (root == null) return "N";

        String str = root.val + "," + subtrees(root.left, hm, ans) + "," + subtrees(root.right, hm,ans);
        // Checking for only once because even if it appears more than once, we don't need to add it many times in the ans.
        if (hm.getOrDefault(str, 0) == 1){
            ans.add(root);
        }
        hm.put(str, hm.getOrDefault(str, 0) + 1);

        return str;
    }
}
