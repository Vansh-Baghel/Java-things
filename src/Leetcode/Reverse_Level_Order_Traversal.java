package Leetcode;

import java.util.*;

public class Reverse_Level_Order_Traversal {
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


    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q=  new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur=q.poll();
            // adding at 0th index
            ans.add(0,cur.data);
            if(cur.right!=null) q.offer(cur.right);
            if(cur.left!=null) q.offer(cur.left);
        }
        return ans;

    }
}
