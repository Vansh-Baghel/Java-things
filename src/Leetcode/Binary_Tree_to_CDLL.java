package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_to_CDLL {
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
        Integer[] parentArray = {1,2,3};
        Node root = constructBinaryTree(parentArray);
        display(bTreeToClist(root));
    }

    static Node bTreeToClist(Node root) {
        List<Integer> list = new ArrayList<>();
        Node head = null;
        Node prev = null;

        storeInorder(list, root);
        int n = list.size();

        for (int i = 0; i < n; i++) {
            Node cur = new Node(list.get(i));
            if (head == null){
                head=cur;
                prev=cur;
            } else {
                prev.right = cur;
                cur.left = prev;
            }

            prev=cur;
        }

        head.left=prev;
        prev.right=head;

        return head;
    }

    static void storeInorder(List<Integer> list, Node root) {
        if (root == null) return;

        storeInorder(list, root.left);
        list.add(root.data);
        storeInorder(list, root.right);
    }

    static Node head = null, prev=null;

    static Node bTreeToClist2(Node root) {
        inorderTraverse(root);

        head.left = prev;
        prev.right = head;

        return head;
    }

    private static void inorderTraverse(Node root) {
        if (root == null) return;

        inorderTraverse(root.left);

        if (head==null) {
            head=prev=root;
        } else {
            prev.right=root;
            root.left=prev;
        }

        prev=root;

        inorderTraverse(root.right);
    }
}
