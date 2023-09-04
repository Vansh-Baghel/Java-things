package Leetcode;
import java.util.*;

public class Top_View_Of_Binary_Tree {
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

    public static class Pair{
        int hd;
        Node node;

        Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    public static ArrayList<Integer> getTopView(Node root) {
        // Write your code here.
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
            if (!hm.containsKey(cur.hd)){
                hm.put(cur.hd, cur.node.data);
            }

            if(cur.node.left != null) q.add(new Pair(cur.hd - 1, cur.node.left));
            if(cur.node.right != null) q.add(new Pair(cur.hd + 1, cur.node.right));
        }

        ans.addAll(hm.values());

        return ans;
    }
}
