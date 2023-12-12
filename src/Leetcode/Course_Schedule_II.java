package Leetcode;

import java.util.*;

public class Course_Schedule_II {
    public static void main(String[] args) {
        int[][] prerequisites = {{0,1}, {1, 0}};

        System.out.println(Arrays.toString(findOrder(2, prerequisites)));
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] ans = new int[numCourses];
        int idx = 0, size=0;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v);
            indegree[v]++;
        };

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int u = q.poll();
            ans[idx++]=u;
            size++;

            for (int v: adj.get(u)){
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        System.out.println(size);
        System.out.println(numCourses);

        return size != numCourses ? ans : new int[]{};
    }


    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        boolean[] inRecursion = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        int[] ans = new int[numCourses];
        int idx = 0;
        Stack<Integer> st = new Stack<>();

        List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

            for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v);
        }

            for (int i = 0; i < numCourses; i++) {
            if (!vis[i] && isCycleDFS(i, adj, vis, inRecursion, ans, st)){
                return new int[]{};
            }
        }

            while (!st.isEmpty()) ans[idx++] = st.pop();
        return ans;
    }

    private boolean isCycleDFS(int u, List<List<Integer>> adj, boolean[] vis, boolean[] inRecursion, int[] ans, Stack<Integer> st) {
        vis[u] = true;
        inRecursion[u]=true;

        for (int v: adj.get(u)){
            if (!vis[v] && isCycleDFS(v, adj, vis, inRecursion, ans, st)) return true;
            else if (inRecursion[v]) return true;
        }

        st.add(u);
        inRecursion[u]=false;

        return false;
    }
}
