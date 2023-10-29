package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Duplicate_subtree_in_Binary_Tree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int dupSub(Node root) {
        HashSet<String> hs = new HashSet<>();

        return createString(hs, root).equals("Y") ? 1 : 0;
    }

    static String createString(HashSet<String> hs, Node root) {
        if (root == null) return "N";

        if (root.left == null && root.right == null) return root.data + "";

        String left = createString(hs, root.left);

        if (left.equals("Y")) return "Y";

        String right = createString(hs, root.right);
        if (right.equals("Y")) return "Y";

        String str = left + root.data + right;
        if (hs.contains(str)) return "Y";
        hs.add(str);

        return str;
    }
}
