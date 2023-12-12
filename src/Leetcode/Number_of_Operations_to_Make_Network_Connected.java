package Leetcode;

public class Number_of_Operations_to_Make_Network_Connected {
    public static class Disjoint_2{
        int[] rank;
        int[] parent;

        public Disjoint_2(int size){
            rank=new int[size];
            parent=new int[size];

            for (int i = 0; i < size; i++) {
                rank[i] = 0;
                parent[i]=i;
            }
        }

        public int findParent(int i){
            if (parent[i] == i) return i;

            return parent[i] = findParent(parent[i]);
        }

        public void unionByRank(int u, int v){
            int parent_u = findParent(u);
            int parent_v = findParent(v);

            if (parent_u == parent_v) return;

            if (rank[parent_u] == rank[parent_v]){
                parent[parent_v] = parent_u;
                rank[parent_u]++;
            } else if (rank[parent_u] > rank[parent_v]) parent[parent_v] = parent_u;
            else parent[parent_u] = parent_v;
        }
    }

    static int makeConnected(int n, int[][] connections) {
        Disjoint_2 ds = new Disjoint_2(n);
        int totalNodesLeft = n;

        // connections.length indicates the number of edges. To join n nmuber of nodes, we atleast need n - 1 edges.
        if (connections.length < n - 1) return -1;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            int parent_u = ds.findParent(u);
            int parent_v = ds.findParent(v);

            if (parent_u != parent_v) {
                ds.unionByRank(parent_u, parent_v);
                totalNodesLeft--;
                ds.parent[parent_v] = parent_u;
            }
        }

        return totalNodesLeft - 1;
    }
}
