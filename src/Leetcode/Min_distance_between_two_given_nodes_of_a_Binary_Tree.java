package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Min_distance_between_two_given_nodes_of_a_Binary_Tree {
    static class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    static class Pair{
        Node node;
        int dist;

        Pair(Node node, int dist){
            this.node = node;
            this.dist = dist;
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
        Integer[] parentArray = {1,2,3};

        Node root = constructBinaryTree(parentArray);

        System.out.println(findDist(root, 2, 3));
    }

    static int findDist(Node root, int a, int b) {
        // Your code here
        int startDist = -1, endDist = -1, dist = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()){
            if (startDist != -1 && endDist != -1) break;

            int size = q.size();
            dist++;

            for (int i = 0; i < size; i++){
                if (startDist != -1 && endDist != -1) break;
                Pair top = q.poll();
                Node node = top.node;

                if (node.data == a) startDist = top.dist;
                if (node.data == b) endDist = top.dist;

                if (node.left != null) q.add(new Pair(node.left, dist));
                if (node.right != null) q.add(new Pair(node.right, dist));
            }
        }

        return startDist + endDist;
    }
}
