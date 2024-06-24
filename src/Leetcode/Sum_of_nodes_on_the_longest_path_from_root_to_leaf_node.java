package Leetcode;

import java.util.*;

public class Sum_of_nodes_on_the_longest_path_from_root_to_leaf_node {

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

    public static int maxLevel = 0;

    public static void main(String[] args) {
        Integer[] parentArray = {3, 9, 1, 1, 5, null, null, 3, 7, 4, 5, null, null, null, null, null, null, null, null};

        Node root = constructBinaryTree(parentArray);

        System.out.println(sumOfLongRootToLeafPath(root));
    }


    public static int sumOfLongRootToLeafPath(Node root){
        //code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        preOrder(hm, root, 0, 1);

        return hm.get(maxLevel);
    }

    public static void preOrder(HashMap<Integer, Integer> hm, Node root, int sum, int level){
        if (root == null) return;

        sum += root.data;

        if (root.left == null && root.right == null){
            hm.put(level, Math.max(hm.getOrDefault(level, 0), sum));
            maxLevel = Math.max(maxLevel, level);
        }

        preOrder(hm, root.left, sum, level + 1);
        preOrder(hm, root.right, sum, level + 1);
    }
}
