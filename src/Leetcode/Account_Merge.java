package Leetcode;
import java.util.*;

public class Account_Merge {
    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ultp_u = findUPar(u);
            int ultp_v = findUPar(v);

            if (ultp_u == ultp_v) return;
            if (rank.get(ultp_u) < rank.get(ultp_v)) {
                parent.set(ultp_u, ultp_v);
            } else if (rank.get(ultp_u) > rank.get(ultp_v)) {
                parent.set(ultp_v, ultp_u);
            } else {
                // If dono ka rank is same toh attach v to u.
                parent.set(ultp_v, ultp_u);
                int rankU = rank.get(ultp_u);
                rank.set(ultp_u, rankU + 1);
            }
        }
    }

    public static void main (String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
                add(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com","john00@mail.com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));
                add(new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")));
            }
        };

        List<List<String>> ans = accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                // hm will store the mails on child node
                if (!hm.containsKey(mail)){
                    hm.put(mail, i);
                } else {
                    ds.unionByRank(i,hm.get(mail));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();

        // Traversing through hm.
            for (Map.Entry<String, Integer> it : hm.entrySet()) {
            String mail = it.getKey();
            int node = ds.parent.get(it.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> mailWithName = new ArrayList<>();

            // Adding name to new list and then adding all the mails into it from mergedMail.
            mailWithName.add(accounts.get(i).get(0));

            mailWithName.addAll(mergedMail[i]);
            ans.add(mailWithName);
        }
        return ans;
    }
}

