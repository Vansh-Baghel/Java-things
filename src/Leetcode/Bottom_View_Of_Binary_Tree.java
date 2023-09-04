package Leetcode;
import java.util.*;


public class Bottom_View_Of_Binary_Tree {
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
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

    public static ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()){
            Pair cur = q.poll();
            // We just need to update this everytime, and TreeMap will take care of it to replace.
            hm.put(cur.hd, cur.node.val);

            if(cur.node.left != null) q.add(new Pair(cur.hd - 1, cur.node.left));
            if(cur.node.right != null) q.add(new Pair(cur.hd + 1, cur.node.right));
        }

        ans.addAll(hm.values());

        return ans;
    }
}
