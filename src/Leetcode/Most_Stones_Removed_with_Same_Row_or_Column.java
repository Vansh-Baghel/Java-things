package Leetcode;
import java.util.*;

public class Most_Stones_Removed_with_Same_Row_or_Column {
    class DisJointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        //        Constructor
        public DisJointSet(int n){

//        Initially giving the size as 1 to all the nodes.
            for (int i = 0; i <= n; i++) {
                size.add(1);
//            assigning parent to itself in the beginning.
                parent.add(i);
            }}

        //        Function to find the ultimate parent from the connected nodes using recursion.
        public int findUParent(int node){
//        If any node ka parent is itself, it means its the topmost node ie the parent node.
            if (node == parent.get(node)){
                return node;
            }
            //                Do recursion and pass the new node as parent node.
            int ulp = findUParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        //        function to find the size of the nodes and connect 2 nodes depending on the size.
        public void unionBySize(int u, int v){
//        Ultimate parent of u
            int ulp_u = findUParent(u);
//        Ultimate parent of v
            int ulp_v = findUParent(v);

            if (ulp_u == ulp_v) return;

            if (size.get(ulp_u) < size.get(ulp_v)){
//                Setting parent of u as v ka ultimate parent.
                parent.set(ulp_u , ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
            else{
//                Here even if size of both the parent node is same, this condition will take place, do could join any node to other ie u to v or v to u.
                parent.set(ulp_v , ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    public int removeStones(int[][] stones) {
        int count = 0;

        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisJointSet ds = new DisJointSet(maxRow + maxCol + 1);
        // This is the actual list containing stones.
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            // stones[i][0] because in question its mentioned x1 and y1 which are rows and cols.
            int nodeRow = stones[i][0];
            // Taking col as 1 more than the maxRow ie 0th col is taken as 3 where rowLength is 2.
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            // Putting 1 at index which exists.
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            // If the parent is same for multiple stoneNodes, it could be removed.
            if (ds.findUParent(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return stones.length - cnt;
    }
}
