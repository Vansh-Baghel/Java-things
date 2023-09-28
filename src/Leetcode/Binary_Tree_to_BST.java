package Leetcode;

import Leetcode_Manual_Input.BinaryTree;

import java.util.*;

public class Binary_Tree_to_BST {
    static class Node
    {
        int data;
        Node left, right;
        Node(int item){
            data = item;
            left = right = null;
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
        Integer[] parentArray = {1, 2, 3};
        Node root = constructBinaryTree(parentArray);
        binaryTreeToBST(root);
    }

    static Node binaryTreeToBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);

        int e = list.size();
        Node newRoot = constructBst(list, 0, e/2, e);
        display(newRoot);
        return newRoot;
    }

    static Node constructBst(ArrayList<Integer> list, int s, int m, int e) {
        if (s > e) return null;
        m = s + (e-s)/2;
        Node root = new Node(s);
        if(m<e) root = new Node(list.get(m));
        root.left = constructBst( list, s, m, m-1);
        root.right = constructBst( list, m+1, m, e);
        return root;
    }

    static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
