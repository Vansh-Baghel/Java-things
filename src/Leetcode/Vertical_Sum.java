package Leetcode;

import java.util.*;

public class Vertical_Sum {
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

    public static void main(String[] args) {
        Integer[] arr = {9, 8, 7, 9, 10, null, null, null, null, 8, 5, 8, null, null, null, null, null};

        Node root = constructBinaryTree(arr);
        System.out.println(verticalSum(root));
    }

    public static HashMap<Integer, Integer> hm = new HashMap<>();

    public static ArrayList<Integer> verticalSum(Node root) {
        solve(root, 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (var it : hm.entrySet()) {
            pq.offer(new int[]{it.getKey(), it.getValue()});
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll()[1]);

        return res;
    }

    public static void solve(Node root, int lines){
        if (root == null) return;

        solve(root.left, lines-1);
        hm.put(lines, hm.getOrDefault(lines, 0) + root.data);
        solve(root.right, lines+1);
    }
}
