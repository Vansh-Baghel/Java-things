package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_of_Tree {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static int getMaxWidth(Node root) {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int maxi = 0;

        while(!q.isEmpty()){
            int size = q.size();
            maxi = Math.max(size, maxi);

            for (int i = 0; i < size; i++) {
                Node top = q.poll();
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
        }

        return maxi;
    }
}
