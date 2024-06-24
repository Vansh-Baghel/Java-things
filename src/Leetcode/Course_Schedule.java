package Leetcode;
import java.util.*;

public class Course_Schedule {
    public static void main(String[] args) {
        int[][] prerequisitesArray = {{12, 2}, {6, 0}, {0, 1}};

        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for (int[] pair : prerequisitesArray) {
            ArrayList<Integer> prerequisitePair = new ArrayList<>();
            for (int num : pair) {
                prerequisitePair.add(num);
            }
            prerequisites.add(prerequisitePair);
        }

        System.out.println(Arrays.toString(findOrder2(2, 1, prerequisites)));
    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int V = n;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[V];
        int[] ans = new int[n];
        int ind = 0;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            // We are adding the adj for the second num as its first num because in the question it has been given that for task 0, we have to first complete 1.
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        for (int i = 0; i < V; i++) {
            for(int it: adj.get(i)){
                inorder[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inorder[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int top = q.poll();
            ans[ind++] = top;

            for(int it: adj.get(top)){
                inorder[it]--;
                if(inorder[it] == 0) q.add(it);
            }
        }

        if (ind == V) return ans;
        int[] arr = {};
        return arr;
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int size = 0;
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

        System.out.println(Arrays.toString(indegree));

        while (!q.isEmpty()){
            int u = q.poll();
            size++;

            for (int v: adj.get(u)){
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        return size == numCourses;
    }


    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        boolean[] inRecursion = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];

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
            if (!vis[i] && isCycleDFS(i, adj, vis, inRecursion)){
                return false;
            }
        }

        return true;
    }

    private boolean isCycleDFS(int u, List<List<Integer>> adj, boolean[] vis, boolean[] inRecursion) {
        vis[u] = true;
        inRecursion[u]=true;

        for (int v: adj.get(u)){
            if (!vis[v] && isCycleDFS(v, adj, vis, inRecursion)) return true;
            else if (inRecursion[v]) return true;
        }

        inRecursion[u]=false;

        return false;
    }



    static int[] findOrder2(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // DFS mai 2 arrays use krna hoga, BFS mai Kahn's Algo for Topological sort will work.

        // Why vis failed? Because aise bhi
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> pre: prerequisites){
            int u = pre.get(1), v = pre.get(0);
            adj.get(u).add(v);

            // Means andar aara hai arrow, waha plus krdo
            indegree[v]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int idx = 0;

        while (!q.isEmpty()){
            int s = q.size();

            for (int i = 0; i < s; i++){
                int node = q.poll();
                res[idx++] = node;

                for (int it: adj.get(node)){
                    indegree[it]--;

                    if (indegree[it] == 0){
                        q.add(it);
                    }
                }
            }
        }

        if (idx == n) return res;

        return new int[]{};
    }
}
