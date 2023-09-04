package Leetcode;
import java.util.*;

public class Implementing_Dijkstra_Algorithm {
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Creating and adding the first inner list
        ArrayList<ArrayList<Integer>> innerList1 = new ArrayList<>();
        innerList1.add(new ArrayList<>(java.util.Arrays.asList(1, 1)));
        innerList1.add(new ArrayList<>(java.util.Arrays.asList(2, 6)));
        adj.add(innerList1);

        // Creating and adding the second inner list
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

    // Using minHeap priorityQueue.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((x,y) -> x.first - y.first);

        int[] shortestPath = new int[V];

        for (int i = 0; i < V; i++) {
            shortestPath[i] = Integer.MAX_VALUE;
        }

        shortestPath[S] = 0;
        minHeap.add(new Pair(0, S));

        while(!minHeap.isEmpty()){
            Pair node = minHeap.poll();

            for(ArrayList<Integer> ls: adj.get(node.second)){
                    int it = ls.get(0);
                    int wt = ls.get(1);
                    // shortestPath[node.first] contains the old time in weights to reach
                    int totalWt = wt + node.first;

                    if (shortestPath[it] > totalWt){
                        shortestPath[it] = totalWt;
                        minHeap.add(new Pair(totalWt, it));
                    }
            }
        }

        return shortestPath;
    }
}
