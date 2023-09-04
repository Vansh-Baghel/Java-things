package Leetcode;
import java.util.*;

public class Vertical_Order_Traversal_of_a_Binary_Tree {
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

    public static class Tuple {
        TreeNode node;
        int hd;
        int vd;

        Tuple(int hd, int vd, TreeNode node) {
            this.node = node;
            this.hd = hd;
            this.vd = vd;
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
        Integer[] parentArray = {1,2,3,4,6,5,7};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(verticalTraversal(root));
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap because we need the output in the sorted order. Like vertical length from left to right.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> hm = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // Adding in queue, and then checking it for hashmap.
        q.add(new Tuple(0,0, root));

        while (!q.isEmpty()){
            Tuple cur = q.poll();

            // Adding the 3 values in hashmap one by one.
            if(!hm.containsKey(cur.hd)){
                hm.put(cur.hd, new TreeMap<>());
            }
            // checking the vd ie 0, 1, 2, etc levels from top to bottom, so if both are same for some value, we could add the value in the priority queue.
            if (!hm.get(cur.hd).containsKey(cur.vd)){
                hm.get(cur.hd).put(cur.vd, new PriorityQueue<>());
            }
            hm.get(cur.hd).get(cur.vd).add(cur.node.val);

            if(cur.node.left != null) q.add(new Tuple(cur.hd - 1,cur.vd + 1, cur.node.left));
            if(cur.node.right != null) q.add(new Tuple(cur.hd + 1,cur.vd + 1, cur.node.right));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> ls: hm.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ls.values()){
                while (!nodes.isEmpty()){
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }

        return ans;
    }
}
