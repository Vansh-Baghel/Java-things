package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Inorder_Successor_in_BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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

    static Node searchNode(Node root, int p){
        if (root == null) return null;

        if (root.data == p) return root;

        Node left = searchNode(root.left, p);
        if (left!=null) return left;
        Node right = searchNode(root.right, p);
        return right;
    }

    public static void main(String[] args) {
        Integer[] parentArray = {20, 8, 22, 4, 12, null, null, null, null, 10, 14};

        Node root = constructBinaryTree(parentArray);

        Node p = searchNode(root, 8);
        Node ans = inorderSuccessor(root, p);
        System.out.println(ans.data);
    }

    static Node successor = null;
    static Node inorderSuccessor(Node root,Node x) {
        if (root == null) return successor;

        if (root.data > x.data){
            successor = root;
            inorderSuccessor(root.left, x);
        } else {
            inorderSuccessor(root.right, x);
        }
        return successor;
    }
}
