package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Kth_Largest_Element_in_a_BST {
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
        Integer[] parentArray = {8,6,9,4,7,null,null,3};
        Node root = constructBinaryTree(parentArray);
        int ans = kthLargest2(root, 5);
        System.out.println(ans);
    }

    public static int kthLargest(Node root, int k) {
        int totalCount = countTotalNodes(root);
        // Finding smallest using inorder is the way to solve this, and when largest is required, we could use totalCount - k + 1 which will return the kth largest element.
        Node small=recursionInorder(root,new int[]{totalCount - k + 1});
        return small.data;
    }

    private static int countTotalNodes(Node root) {
        if (root == null) return 0;

        return 1 + countTotalNodes(root.left) + countTotalNodes(root.right);
    }

    static Node recursionInorder(Node root, int k[]){
        if(root==null)
            return null;

        Node left=recursionInorder(root.left,k);
        if(left!=null)
            return left;
        k[0]--;
        if(k[0]==0)
            return root;

        return recursionInorder(root.right,k);
    }

    public static int kthLargest2(Node root, int K) {
        int[] count = new int[1];
        int[] ans = new int[1];
        ans[0] = -1;
        rightToLeft(root, K, count, ans);
        return ans[0];
    }

    static void rightToLeft(Node root, int k, int[] count, int[] ans) {
        if (root == null) return;

        if (ans[0] == -1){

            if (count[0] == k) {
                ans[0] = root.data;
            }

            rightToLeft(root.right, k, count, ans);
            count[0]++;

            // Condition for the left side roots. If ye nhi dala toh left side mai jo counts increase hore toh that is not being checked.
            if (count[0] == k) {
                ans[0] = root.data;
            }
            rightToLeft(root.left, k, count, ans);
        }
    }
}
