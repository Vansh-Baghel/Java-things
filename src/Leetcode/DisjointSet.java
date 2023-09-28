package Leetcode;
import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if (node == parent.get(node)){
            return node;
        }

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultp_u = findUPar(u);
        int ultp_v = findUPar(v);

        if (ultp_u == ultp_v) return;
        if (rank.get(ultp_u) < rank.get(ultp_v)) {
            parent.set(ultp_u, ultp_v);
        } else if (rank.get(ultp_u) > rank.get(ultp_v)) {
            parent.set(ultp_v, ultp_u);
        } else {
            // If dono ka rank is same toh attach v to u.
            parent.set(ultp_v, ultp_u);
            int rankU = rank.get(ultp_u);
            rank.set(ultp_u, rankU+1);
        }
    }
        public static void main (String[] args) {
            DisjointSet ds = new DisjointSet(7);
            ds.unionByRank(1, 2);
            ds.unionByRank(2, 3);
            ds.unionByRank(4, 5);
            ds.unionByRank(6, 7);
            ds.unionByRank(5, 6);

            // if 3 and 7 same or not
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");

            ds.unionByRank(3, 7);
            if (ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else
                System.out.println("Not Same");
        }
}

