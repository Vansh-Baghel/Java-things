package Leetcode;

import java.util.*;

public class Brothers_From_Different_Roots {
    class Node
    {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    static int countPairs(Node root1, Node root2, int x) {
        HashSet<Integer> hs = new HashSet<>();
        int[] ans = {0};

        traverseFirst(root1, hs, x);
        traverseSecond(root2, hs, ans);

        return ans[0];
    }

    private static void traverseSecond(Node root, HashSet<Integer> hs, int[] ans) {
        if (root == null) return;
        if (hs.contains(root.data)) ans[0]++;
        traverseSecond(root.left, hs, ans);
        traverseSecond(root.right, hs, ans);
    }

    private static void traverseFirst(Node root, HashSet<Integer> hs, int x) {
        if (root == null) return;

        hs.add(x - root.data);
        traverseFirst(root.left, hs, x);
        traverseFirst(root.right, hs, x);
    }
}
