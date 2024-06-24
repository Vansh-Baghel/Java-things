package Leetcode.Contest;

import java.util.LinkedList;
import java.util.Queue;

public class Closest_Neighbour_in_BST {
    static class Node {
        int key;
        Node left;
        Node right;
        Node() {}
        Node(int key) { this.key = key; }
        Node(int key, Node left, Node right) {
            this.key = key;
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
        Integer[] parentArray = {5,2,12,1,3,9,21,null,null,19,25};
        Node root = constructBinaryTree(parentArray);
        System.out.println(findMaxForN(root, 4));
    }

    static int res = -1;

    static int findMaxForN(Node root, int n) {
        // Add your code here.
        solve(root, n);
        int temp = res;
        res = -1;
        return temp > n ? -1 : temp;
    }

    static void solve(Node root, int n) {
        if (root == null) return;

        if (root.key > n) solve(root.left, n);
        else {
            res = root.key;
            solve(root.right, n);
        }
    }
}
