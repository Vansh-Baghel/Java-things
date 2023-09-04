package Leetcode;
import java.util.*;

public class Binary_Tree_Level_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // Condition where there are no nodes.
        if (root == null) return ans;

        q.add(root);

        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            // The size will run the loop that number of times, so each level ke nodes will be stored.
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // Adding the root ka left and right into the queue.
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                // This will add the roots ie left and right jo bhi hai.
                list.add(q.poll().val);
            }
            ans.add(list);
        }
        return ans;
    }
}
