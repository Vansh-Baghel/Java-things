package Leetcode.Contest;

import java.util.*;

public class Find_Number_of_Coins_to_Place_in_Tree_Nodes {

    static public class GraphNode {
    int subTrees;
    List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();

    GraphNode(int cost) {
        subTrees = 1;
        if (cost > 0) pos.add(cost);
        else neg.add(cost);
    }

    void updateParNode(GraphNode childNode) {
        subTrees += childNode.subTrees;

        // Append child k lists into parents
        pos.addAll(childNode.pos);
        neg.addAll(childNode.neg);

        // Sort it properly as required
        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        // Just keep the top 3 pos nums
        for (int i = 3; i < pos.size(); i++) {
            pos.remove(i);
        }
        // Just keep the top 2 neg nums
        for (int i = 2; i < neg.size(); i++) {
            neg.remove(i);
        }
    }

    public long findProduct() {
        if (subTrees < 3) return 1;

        int prod = 1, posSize = pos.size();

        if (posSize == 3) prod = pos.get(0) * pos.get(1) * pos.get(2);
        if (neg.size() == 2 && posSize != 0) prod = Math.max(prod, neg.get(0) * neg.get(1) * pos.get(0));

        return prod;
    }
}

    public long[] placedCoins(int[][] edges, int[] cost) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = cost.length;
        long[] res = new long[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(0, -1, adj, cost, res);

        return res;
    }

    private GraphNode dfs(int idx, int parIdx, List<List<Integer>> adj, int[] cost, long[] res) {
        GraphNode node = new GraphNode(cost[idx]);

        for (int childIdx : adj.get(idx)) {
            if (childIdx != parIdx) {
                GraphNode childNode = dfs(childIdx, idx, adj, cost, res);
                node.updateParNode(childNode);
            }
        }

        res[idx] = node.findProduct();

        return node;
    }
}
