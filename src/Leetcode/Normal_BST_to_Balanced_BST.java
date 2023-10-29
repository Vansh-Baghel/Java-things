package Leetcode;

import java.util.*;

public class Normal_BST_to_Balanced_BST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node constructBinaryTree(Integer[] parentArray) {
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

    public static void main(String[] args) {
        Integer[] parentArray = {1,2,3};
        Node root = constructBinaryTree(parentArray);
        System.out.println(buildBalancedTree(root));
    }

    static Node buildBalancedTree(Node root) {
        List<Integer> inorder = new ArrayList<>();
        constructInorder(root, inorder);

        Node ans = makeBalancedBST(inorder, 0, inorder.size() - 1);

        return ans;
    }

    private static Node makeBalancedBST(List<Integer> inorder, int s, int e) {
        if (s > e) return null;

        int mid = (s + e) / 2;

        Node root = new Node(inorder.get(mid));

        root.left = makeBalancedBST(inorder, s, mid - 1);
        root.right = makeBalancedBST(inorder, mid + 1, e);

        return root;
    }

    private static void constructInorder(Node root, List<Integer> inorder) {
        if (root == null) return;

        constructInorder(root.left, inorder);
        inorder.add(root.data);
        constructInorder(root.right, inorder);
    }
}
