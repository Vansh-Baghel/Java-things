package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Predecessor_and_Successor {
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
        Integer[] parentArray = {10, 2, 11, 1, 5, null, null, null, null, 3, 6, null, 4};

        Node root = constructBinaryTree(parentArray);

        findPreSuc(root, 8);
        System.out.println(suc.data);
        System.out.println(pre.data);
    }

    static Node suc = null;
    static Node pre = null;
    static void findPreSuc(Node root, int key) {
        suc = findSuc (root, key);
        pre = findPre (root, key);
    }

    private static Node findSuc(Node root, int key) {
        if (root == null) return suc;

        if (root.data > key){
            suc = root;
            findSuc(root.left, key);
        } else {
            findSuc(root.right, key);
        }
        return suc;
    }

    private static Node findPre(Node root, int key) {
        if (root == null) return pre;

        if (root.data >= key){
            findPre(root.left, key);
        } else {
            pre = root;
            findPre(root.right, key);
        }
        return pre;
    }
}
