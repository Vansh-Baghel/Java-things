package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_from_Postorder_and_Inorder {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
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
        System.out.print(root.val + "-> ");
        System.out.print(root.left == null ? "null, " : root.left.val + ", ");
        System.out.println(root.right == null ? "null" : root.right.val);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        int[] i = {9,3,15,20,7}, p = {9,15,7,20,3};
        display(buildTree(i, p, i.length));
    }

    static Node buildTree(int in[], int post[], int n) {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            hm.put(in[i], i);
        }
        Node root = formTree(in, post, 0, in.length-1, 0, post.length-1, hm);
        return root;
    }

    private static Node formTree(int[] in, int[] post, int inStart, int inEnd, int postStrt, int postEnd, HashMap<Integer, Integer> hm) {
        if (inStart > inEnd || postStrt > postEnd) return null;

        int rootIdx = hm.get(post[postEnd]);
        int leftLength = rootIdx - inStart;

        Node root = new Node(post[postEnd]);

        root.left = formTree(in, post, inStart, rootIdx - 1, postStrt, postStrt + leftLength - 1, hm);
        root.right = formTree(in, post, rootIdx + 1,  inEnd, postStrt + leftLength, postEnd - 1, hm);

        return root;
    }
}
