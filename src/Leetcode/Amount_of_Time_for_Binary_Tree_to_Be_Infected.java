package Leetcode;

import java.util.*;

public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

        // 2 passes
        public int amountOfTime(TreeNode root, int start) {
            HashMap<Integer, TreeNode> hm = new HashMap<>();
            List<Integer> vis = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode tmp = new TreeNode(-1);
            int res = 0;

            List<TreeNode> inf = new ArrayList<>();
            // Parent form karo
            formParent(hm, root, tmp, inf, start);

            // Infected find karo and q mai daalo
            // TreeNode inf = findInfected(start, root);

            // q chaalao jab tk its not empty
            q.add(inf.get(0));
            vis.add(inf.get(0).val);

            while (!q.isEmpty()){
                int size = q.size();

                for (int i = 0; i < size; i++){
                    TreeNode top = q.poll();
                    TreeNode par = hm.get(top.val);

                    if (top.left != null && !vis.contains(top.left.val)) {
                        vis.add(top.left.val);
                        q.add(top.left);
                    };
                    if (top.right != null && !vis.contains(top.right.val)) {
                        vis.add(top.right.val);
                        q.add(top.right);
                    };
                    if (par.val != -1 && !vis.contains(par.val)) {
                        vis.add(par.val);
                        q.add(par);
                    }
                }

                res++;
            }

            return res - 1;
        }

    static void formParent(HashMap<Integer, TreeNode> hm, TreeNode root, TreeNode par, List<TreeNode> inf, int start){
        if (root == null) return;

        if (root.val == start) inf.add(root);

        hm.put(root.val, par);

        formParent(hm, root.left, root, inf, start);
        formParent(hm, root.right, root, inf, start);
    }

    // static TreeNode findInfected(int infected, TreeNode root){
    //     if (root == null) return null;

    //     if (root.val == infected) return root;

    //     TreeNode left = findInfected(infected, root.left);
    //     if (left != null) return left;
    //     TreeNode right = findInfected(infected, root.right);
    //     if (right != null) return right;

    //     return null;
    // }


    // 1 pass
    public int res = Integer.MIN_VALUE;

    public int amountOfTime2(TreeNode root, int start) {
        solve(root, start);
        return res;
    }

    public int solve(TreeNode root, int start){
        if (root == null) return 0;

        int left = solve(root.left, start);
        int right = solve(root.right, start);

        if (root.val == start){
            res = Math.max(left, right);
            return -1;
        } else if (left >= 0 && right >= 0){
            return Math.max(left, right) + 1;
        } else {
            // This condition is when start mil jaaye, start will return negative value. res mai we are adding left and right because it we want to have the distance of the nodes wrt to the start, therefore start se upar waale node ka difference + left or right jo hai will give it.
            int dist = Math.abs(left) + Math.abs(right);
            // Hence finding the max from it
            res = Math.max(res, dist);
            return Math.min(left, right) - 1;
        }
    }
}
