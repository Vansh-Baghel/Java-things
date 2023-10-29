package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Complete_Binary_Tree {
    static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
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
        System.out.println(isCompleteBT(root));
    }

    static boolean isCompleteBT(Node root){
        boolean past = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node top = q.poll();

                if (top == null) {
                    past = true;
                    continue;
                }

                else if (past) return false;

                q.add(top.left);
                q.add(top.right);
            }
        }

        return true;
    }
}
