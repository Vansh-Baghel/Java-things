package Leetcode;

import java.util.*;

public class Keys_and_Rooms {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(4));
        graph.add(Arrays.asList(3));
        graph.add(new ArrayList<>());  // Empty list for the third node
        graph.add(Arrays.asList(2, 5, 7));
        graph.add(Arrays.asList(1));
        graph.add(new ArrayList<>());  // Empty list for the sixth node
        graph.add(Arrays.asList(8, 9));
        graph.add(new ArrayList<>());  // Empty list for the eighth node
        graph.add(new ArrayList<>());  // Empty list for the ninth node
        graph.add(Arrays.asList(6));

        System.out.println(canVisitAllRooms(graph));
    }

    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];

         dfs(0, vis, rooms);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }

    private static void dfs(int u, boolean[] vis, List<List<Integer>> rooms) {
        if (vis[u]) return;
        vis[u] = true;

        for (int v: rooms.get(u)){
            if(!vis[v]){
                dfs(v, vis, rooms);
            }
        }
    }
}
