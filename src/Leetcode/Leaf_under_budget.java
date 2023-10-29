package Leetcode;

import Leetcode_Manual_Input.BinaryTree;

import java.util.*;

public class Leaf_under_budget {
    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }

    public static class Pair{
        int level;
        Node node;

        Pair(Node node, int level){
            this.node = node;
            this.level = level;
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
        Integer[] parentArray = {10,8,2,3,null,3,6,null,null,4};
        Node root = constructBinaryTree(parentArray);

        System.out.println(getCount(root, 8));
    }

    static int getCount(Node node, int bud){
        //code here
        Queue<Pair> q = new LinkedList<>();
        int count=0;
        q.add(new Pair(node, 1));

        while (!q.isEmpty()){
            int size = q.size();
            if (bud <= 0) break;

            for (int i = 0; i < size; i++) {
                Pair top = q.poll();
                Node curNode = top.node;
                int lvl = top.level;

                if (bud >= lvl) if (curNode.left == null && curNode.right == null) {
                    bud -= lvl;
                    count++;
                }

                if (curNode.left != null) q.add(new Pair(curNode.left, lvl+1));
                if (curNode.right != null) q.add(new Pair(curNode.right, lvl+1));
            }
        }

        return count;
    }
}
