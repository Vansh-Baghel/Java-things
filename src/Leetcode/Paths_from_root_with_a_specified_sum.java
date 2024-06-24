package Leetcode;

import java.util.*;

public class Paths_from_root_with_a_specified_sum {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
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
        Integer[] parentArray = {1, 20, 3, null, null, 4, 15, 6, 7, 8, 9};
        Node root = constructBinaryTree(parentArray);
        System.out.println(printPaths(root, 8));
    }

    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum){
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, sum, list, res);

        return res;
    }

    static void solve(Node root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        if (root == null || sum < 0) return;

        if (sum == root.data) {
            list.add(root.data);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.data);
        solve(root.left, sum-root.data, list, res);
        solve(root.right, sum-root.data, list, res);
        list.remove(list.size() - 1);
    }
}
