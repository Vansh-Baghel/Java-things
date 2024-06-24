package Leetcode;

import Leetcode_Manual_Input.BinaryTree;

import java.util.*;

class Count_the_nodes_at_distance_K_from_leaf {
    static class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
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
        Integer[] parentArray = {17, 17, null, 7, 17, null, null, 9, 6, null, null, 5, 3, 13, 14, null, null, null, null, null, null, null};

        int k = 3;

        Node root = constructBinaryTree(parentArray);

        System.out.println(printKDistantfromLeaf(root, k));
    }

    static Set<Node> hs = new HashSet<>();

    static int printKDistantfromLeaf(Node root, int k){
        HashMap<Integer, List<Node>> hm = new HashMap<>();

        solve(root, k, 0, hm);

        int res = hs.size();

        hs = new HashSet<>();

        return res;
    }

    public static void solve(Node root, int k, int level, HashMap<Integer, List<Node>> hm){
        if (root == null) return;

        if (root.left == null && root.right == null){
            if (level >= k){
                if (k == 0) hs.add(root);
                else{
                    if (hm.get(level-k) == null) return;
                    List<Node> tmp = hm.get(level-k);
                    hs.addAll(tmp);
                }
                return;
            }
        }

        hm.computeIfAbsent(level, x -> new ArrayList<>()).add(root);

        solve(root.left, k, level + 1, hm);
        solve(root.right, k, level + 1, hm);

        hm.get(level).remove(hm.get(level).size() - 1);
    }
}
