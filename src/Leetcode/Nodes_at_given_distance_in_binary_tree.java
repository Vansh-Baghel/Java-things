package Leetcode;

import java.util.*;

public class Nodes_at_given_distance_in_binary_tree {
    static class Node {
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
        Integer[] parentArray = {20, 8, 22, 4, 12, null, null, null, 10, 14};
        Node root = constructBinaryTree(parentArray);
        ArrayList<Integer> ans = KDistanceNodes(root, 8,2);
        System.out.println(ans);
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Node, Node> parentHm = new HashMap<>();
        HashMap<Node, Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node tar = findTarget(root, target);
        formParentMap(root, parentHm);

        q.add(tar);
        vis.put(tar, true);

        while (!q.isEmpty()){
            int size = q.size();
            if (k == 0) break;
            k--;

            for (int i = 0; i < size; i++) {
                Node top = q.poll();
                Node par = parentHm.get(top);

                if (top.left != null && vis.get(top.left) == null) {
                    q.add(top.left);
                    vis.put(top.left, true);
                }

                if (top.right != null && vis.get(top.right) == null) {
                    q.add(top.right);
                    vis.put(top.right, true);
                }

                if (par != null && vis.get(par) == null){
                    q.add(par);
                    vis.put(par, true);
                }
            }
        }

        while (!q.isEmpty()) ans.add(q.poll().data);
        Collections.sort(ans);
        return ans;
    }

    private static void formParentMap(Node root, HashMap<Node, Node> parentHm) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            Node top = q.poll();

            if (top.left != null) {
                q.add(top.left);
                parentHm.put(top.left, top);
            }

            if (top.right != null) {
                q.add(top.right);
                parentHm.put(top.right, top);
            }

        }
    }

    private static Node findTarget(Node root, int target) {
        if (root == null) return null;

        if (root.data == target) return root;

        Node left = findTarget(root.left, target);
        Node right = findTarget(root.right, target);
        if (left != null) return left;
        else return right;
    }
}
