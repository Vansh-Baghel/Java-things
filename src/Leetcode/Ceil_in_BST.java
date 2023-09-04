package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Ceil_in_BST {
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
        Integer[] parentArray = {10,5,11,4,7,null,null,null,null,null,8};
        Node root = constructBinaryTree(parentArray);
        int ans = findCeil(root, 12);
        System.out.println(ans);;
    }

    static int ceil = -1;
    static int findCeil(Node root, int key) {
        while (root != null){
            if (root.data > key) {
                ceil=root.data;
                root=root.left;
            } else if (root.data < key) {
                root=root.right;
            } else if (root.data == key) {
                ceil = root.data;
                return ceil;
            }
        }

        return ceil;
    }
}
