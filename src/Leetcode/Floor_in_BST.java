package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Floor_in_BST {
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

    public static void main(String[] args) {
        Integer[] parentArray = {7, 2, 6, 5, 4};
        Node root = constructBinaryTree(parentArray);
        int ans = floor(root, 1);
        System.out.println(ans);
    }

    static int ans = -1;

    public static int floor(Node root, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node top = q.poll();

                if (top.data > x) {
                    if (top.left != null) {
                        q.add(top.left);
                    }
                } else if (top.data < x) {
                    if (top.right != null) {
                        q.add(top.right);
                    }
                    ans = top.data;
                } else return top.data;
            }
        }

        return ans;
    }

    public static int floor2(Node root, int x) {
        findFloor(root, x);
        return ans;
    }

    private static void findFloor(Node root, int x) {
        if (root == null) return;

        if (ans == x) return;
        if (root.data < x) {
            ans = root.data;
            findFloor(root.right, x);
        } else if (root.data > x) findFloor(root.left, x);
        else ans = root.data;
    }
}