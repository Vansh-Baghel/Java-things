package Leetcode;
import java.util.*;

public class Implementing_Dijkstra_Algorithm {
    static class Pair {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Creating and adding the distance inner list
        ArrayList<ArrayList<Integer>> innerList1 = new ArrayList<>();
        innerList1.add(new ArrayList<>(java.util.Arrays.asList(1, 1)));
        innerList1.add(new ArrayList<>(java.util.Arrays.asList(2, 6)));
        adj.add(innerList1);

        // Creating and adding the node inner list
        ArrayList<ArrayList<Integer>> innerList2 = new ArrayList<>();
        innerList2.add(new ArrayList<>(java.util.Arrays.asList(2, 3)));
        innerList2.add(new ArrayList<>(java.util.Arrays.asList(0, 1)));
        adj.add(innerList2);

        // Creating and adding the third inner list
        ArrayList<ArrayList<Integer>> innerList3 = new ArrayList<>();
        innerList3.add(new ArrayList<>(java.util.Arrays.asList(1, 3)));
        innerList3.add(new ArrayList<>(java.util.Arrays.asList(0, 6)));
        adj.add(innerList3);

        int[] ans = dijkstra(3, adj, 2);
        System.out.println(Arrays.toString(ans));
    }

    // Using treeMap priorityQueue.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> treeMap = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] shortestPath = new int[V];

        for (int i = 0; i < V; i++) {
            shortestPath[i] = Integer.MAX_VALUE;
        }

        shortestPath[S] = 0;
        treeMap.add(new Pair(0, S));

        while (!treeMap.isEmpty()) {
            Pair node = treeMap.poll();

            for (ArrayList<Integer> ls : adj.get(node.node)) {
                int it = ls.get(0);
                int wt = ls.get(1);
                // shortestPath[node.distance] contains the old time in weights to reach
                int totalWt = wt + node.distance;

                if (shortestPath[it] > totalWt) {
                    shortestPath[it] = totalWt;
                    treeMap.add(new Pair(totalWt, it));
                }
            }
        }

        return shortestPath;
    }

    static int[] dijkstra2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Pair> treeMap = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        minDist[S] = 0;
        treeMap.add(new Pair(0, S));

        while (!treeMap.isEmpty()) {
            Pair top = treeMap.poll();
            int node = top.node;
            int dist = top.distance;

            for (ArrayList<Integer> pair : adj.get(node)) {
                int adjNode = pair.get(0);
                int adjDist = pair.get(1);
                int totalDist = dist + adjDist;

                if (totalDist < minDist[adjNode]) {
                    minDist[adjNode] = totalDist;
                    treeMap.add(new Pair(totalDist, adjNode));
                }
            }
        }

        return minDist;
    }

    static int[] dijkstra3(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        TreeSet<Pair> treeMap = new TreeSet<>(new Comparator<>() {
            public int compare(Pair a, Pair b) {
                if (a.distance == b.distance)
                    return a.node - b.node;
                return a.distance - b.distance;
            }
        });

        minDist[S] = 0;
        treeMap.add(new Pair(0, S));

        while (!treeMap.isEmpty()) {
            Pair top = treeMap.pollFirst();
            int node = top.node;
            int dist = top.distance;

            for (ArrayList<Integer> pair : adj.get(node)) {
                int adjNode = pair.get(0);
                int adjDist = pair.get(1);
                int totalDist = dist + adjDist;

                if (totalDist < minDist[adjNode]) {
                    minDist[adjNode] = totalDist;
                    treeMap.add(new Pair(totalDist, adjNode));
                }
            }
        }

        return minDist;
    }
}
