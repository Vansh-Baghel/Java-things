package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Root_to_leaf_paths_sum {
    static class Node
    {
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }

    public static Node constructBinaryTree(Integer[] parentArray) {
        if (parentArray == null || parentArray.length == 0) {
            return null;
        }
        Node root = new Node(parentArray[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (index < parentArray.length && parentArray[index] != null) {
                current.left = new Node(parentArray[index]);
                queue.add(current.left);
            }
            index++;

            if (index < parentArray.length && parentArray[index] != null) {
                current.right = new Node(parentArray[index]);
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    private static void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + "-> ");
        System.out.print(root.left == null ? "null, " : root.left.data + ", ");
        System.out.println(root.right == null ? "null" : root.right.data);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Integer[] parentArray1 = {4,9,0,5,1};
        Node root = constructBinaryTree(parentArray1);

        long ans = treePathsSum(root);
        System.out.println(ans);
    }

    public static long treePathsSum(Node root) {
        long ans = allPathSum(root, 0);
        return ans;
    }

    private static long allPathSum(Node root, int num) {
        if (root == null) return 0;
        num = (num * 10) + root.data;

        if (root.left == null && root.right == null) return num;
        long left = allPathSum(root.left, num);
        long right = allPathSum(root.right, num);
        return left + right;
    }
}
