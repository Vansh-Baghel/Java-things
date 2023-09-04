package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Largest_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class NodeValue {
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    };

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
        Integer[] parentArray = {20, 15, null,null,40,14,21,50};
        Node root = constructBinaryTree(parentArray);
        int ans = largestBst(root);
        System.out.println(ans);
    }

    static int largestBst(Node root) {
        return findLargest(root).maxSize;
    }

    static NodeValue findLargest(Node root) {
        if (root == null) {
            // Maximum value ko ekdum Minimum rakha hai, and minimum value ko ekdum maximum rakha hai so that ye case satisfy ho:
            // root.data > left.maxNode && root.data < right.minNode
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = findLargest(root.left);
        NodeValue right = findLargest(root.right);

        if (root.data > left.maxNode && root.data < right.minNode){
            // For the leaf node, it will contain the very high value for minNode and very low value for maxNode so that the root.data could replace it.
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), (left.maxSize+ right.maxSize + 1));
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}
