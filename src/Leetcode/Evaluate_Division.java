package Leetcode;

import java.util.*;

public class Evaluate_Division {
    static class Pair{
        String node;
        double wt;

        public Pair(String node, double wt){
            this.node=node;
            this.wt=wt;
        }
    }

    private double ans = -1.0;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> hm = new HashMap<>();
        int n = equations.size();

        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double wt = values[i];

            hm.computeIfAbsent(u, k->new ArrayList<>()).add(new Pair(v, wt));
                hm.computeIfAbsent(v, k->new ArrayList<>()).add(new Pair(u, 1.0/wt));
            }

        int qSize = queries.size();
        double[] arr = new double[qSize];

        for (int i = 0; i < qSize; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (hm.containsKey(u)){
                if (u.equals(v)) ans = 1.0;
                else {
                    Set<String> vis = new HashSet<>();
                    dfs(u,v,vis,hm,1.0);
                }
            }

            arr[i] = ans;
            ans=-1.0;
        }
        return arr;
    }

    private void dfs(String src, String des, Set<String> vis, Map<String, List<Pair>> hm, double product) {
        if (vis.contains(src)) return;
        vis.add(src);

        if (src.equals(des)) {
            ans = product;
            return;
        }

        for (Pair top : hm.get(src)) {
            String node = top.node;
            double wt = top.wt;

            dfs(node, des, vis, hm, product * wt);
        }
    }
}
