//package Leetcode;
//
//public class Longest_ZigZag_Path_in_a_Binary_Tree {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int val) {
//            this.val = val;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    public int longestZigZag(TreeNode root) {
//        int[] max= new int[1];
//        max[0] = 0;
//
//        solve(root, max, 0, true);
//        return max[0];
//    }
//
//    static void solve(TreeNode root, int[] max, int steps, boolean goLeft){
//        if (root == null) return;
//
//        // Storing max at every point
//        max[0] = Math.max(max[0], steps);
//        if (goLeft) {
//            solve(root.left, max, steps + 1, false);
//            // We can also move to its right but steps ka counter will be resetted since we have to check all the posibilities.
//            solve(root.right, max, 1, true);
//        } else {
//            solve(root.right, max, steps + 1, true);
//            solve(root.left, max, 1, false);
//        }
//    }
//
//    public int longestZigZag2(TreeNode root) {
//        int[] max= new int[1];
//        max[0] = 0;
//
//        solve2(root, max, 0, 0);
//        return max[0];
//    }
//
//    static void solve2(TreeNode root, int[] max, int left, int right){
//        if (root == null) return;
//
//        max[0] = Math.max(max[0], Math.max(left, right));
//        solve2(root.left, max, right + 1, 0);
//        solve2(root.right, max, 0, left + 1);
//        }
//    }
//}
