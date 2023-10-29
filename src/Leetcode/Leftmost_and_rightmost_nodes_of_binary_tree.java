package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leftmost_and_rightmost_nodes_of_binary_tree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public static class Pair{
        int level;
        Node node;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
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

    public static void main(String[] args) {
        Integer[] parentArray = {1,2,3,4,5,6,7};
        Node root = constructBinaryTree(parentArray);

        printCorner(root);
    }

    static void printCorner(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node top = q.poll();

                if (i == 0 || i == size - 1) System.out.print(top.data + " ");

                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
        }
    }
}
