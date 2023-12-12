package Leetcode;

import org.w3c.dom.ls.LSOutput;

public class Satisfiability_of_Equality_Equations {
    public static class Disjoint_2{
        int[] rank;
        int[] parent;

        public Disjoint_2(int size){
            rank=new int[size];
            parent=new int[size];

            for (int i = 0; i < size; i++) {
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

    public static void main(String[] args) {
        String[] eq = {"a==b","b!=c","c==a"};
        System.out.println(equationsPossible(eq));
    }

    static boolean equationsPossible(String[] equations) {
        int n = equations.length;

        Disjoint_2 ds = new Disjoint_2(n);

        for (String equation : equations) {
            int u = equation.charAt(0);
            int v = equation.charAt(equation.length() - 1);
            char equal_notEqual = equation.charAt(1);

            if (equal_notEqual == '=') {
                ds.unionByRank(u - 'a', v - 'a');
            }
        }

        // Different loops because pehle sab == waale solve krna h and then parent waale. Else such cases will fail => "a==b","b!=c","c==a"
        for (String equation : equations) {
            int u = equation.charAt(0);
            int v = equation.charAt(equation.length() - 1);
            char equal_notEqual = equation.charAt(1);

            if (equal_notEqual == '!') {
                int parent_u = ds.findParent(u - 'a');
                int parent_v = ds.findParent(v - 'a');
                if (parent_u == parent_v) return false;
            }
        }

        return true;
    }
}
