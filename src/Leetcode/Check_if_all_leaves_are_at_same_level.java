package Leetcode;

import java.util.*;

public class Check_if_all_leaves_are_at_same_level {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static class Pair{
        Node node;
        int lvl;

        Pair(Node node, int lvl){
            this.node = node;
            this.lvl = lvl;
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
        Integer[] parentArray = {4, 12, 0, 11, null, null, null, null, null};

        Node root = constructBinaryTree(parentArray);

        System.out.println(check(root));
    }

    static boolean check(Node root){
        // Your code here
        int level = 0, leafLevel = -1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 1));

        while (!q.isEmpty()){
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++){
                Pair top = q.poll();
                Node node = top.node;

                if (node.left != null) q.add(new Pair(node.left, level));
                if (node.right != null) q.add(new Pair(node.right, level));

                if (node.left == null && node.right == null) {
                    if (leafLevel != -1 && leafLevel != top.lvl) return false;
                    leafLevel = top.lvl;
                }
            }
        }

        return true;
    }
}
