package Leetcode.LinkedList;

import java.util.*;

public class Time_To_Burn_Tree {
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
        Integer[] parentArray = {1,2,null};
        Node root = constructBinaryTree(parentArray);
        display(root);
        int timer = minTime(root, 2);
        System.out.println(timer);
    }


    static Node searchNode(Node root, int p){
        if (root == null) return null;

        if (root.data == p) return root;

        Node left = searchNode(root.left, p);
        if (left!=null) return left;
        Node right = searchNode(root.right, p);
        return right;
    }
    private static void parentNodes(Node root, HashMap<Node, Node> parent_hm) {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        parent_hm.put(root, null);

        while (!q.isEmpty()){
            Node cur = q.poll();

            if (cur.left != null) {
                q.add(cur.left);
                parent_hm.put(cur.left, cur);
            } if (cur.right != null){
                q.add(cur.right);
                parent_hm.put(cur.right, cur);
            }
        }
    }

    public static int minTime(Node root, int target) {
        HashMap<Node, Node> parent_hm = new HashMap<>();
        HashSet<Node> vis = new HashSet<>();
        int timer = -1;
        Node targetNode = searchNode(root, target);
        parentNodes(root, parent_hm);
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        vis.add(targetNode);

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                Node par = parent_hm.get(cur);

                if (cur.left != null && !vis.contains(cur.left)){
                    q.add(cur.left);
                    vis.add(cur.left);
                }
                if (cur.right != null && !vis.contains(cur.right)){
                    q.add(cur.right);
                    vis.add(cur.right);
                }
                if (par != null && !vis.contains(par)){
                    q.add(par);
                    vis.add(par);
                }
            }
            timer++;
        }
        return timer;
    }
}
