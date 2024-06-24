package Leetcode.Contest;

import java.util.*;

public class Minimum_Number_of_Operations_to_Make_X_and_Y_Equal {
    private static class Pair {
        int num, dist;
        Pair(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }

    static int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(new Pair(x, 0));
        vis.add(x);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair top = q.poll();
                int node = top.num;
                int distance = top.dist;

                if (node == y) {
                    return distance;
                }

                if (!vis.contains(node + 1)) {
                    vis.add(node + 1);
                    q.add(new Pair(node + 1, distance + 1));
                }

                if (node - 1 >= 1 && !vis.contains(node - 1)) {
                    vis.add(node - 1);
                    q.add(new Pair(node - 1, distance + 1));
                }

                if (node % 5 == 0 && !vis.contains(node / 5)) {
                    vis.add(node / 5);
                    q.add(new Pair(node / 5, distance + 1));
                }

                if (node % 11 == 0 && !vis.contains(node / 11)) {
                    vis.add(node / 11);
                    q.add(new Pair(node / 11, distance + 1));
                }
            }
        }

        return -1;
    }
}
