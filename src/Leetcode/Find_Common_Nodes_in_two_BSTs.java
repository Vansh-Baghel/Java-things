package Leetcode;

import java.util.*;

public class Find_Common_Nodes_in_two_BSTs {
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
        Integer[] parentArray = {3,5,1,6,2,0,8,null,null,7,4};
        Node root1 = constructBinaryTree(parentArray);
        Node root2 = constructBinaryTree(parentArray);
        System.out.println(findCommon(root1, root2));
    }

    public static ArrayList<Integer> findCommon(Node root1, Node root2){
        //code here
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        putInHashSet(root1, hs, ans);
        putInHashSet(root2, hs, ans);

        return ans;
    }

    private static void putInHashSet(Node root, HashSet<Integer> hs, ArrayList<Integer> ans) {
        if (root == null) return;

        if (!hs.contains(root.data)) hs.add(root.data);
        else ans.add(root.data);

        putInHashSet(root.left, hs, ans);
        putInHashSet(root.right, hs, ans);
    }
}
