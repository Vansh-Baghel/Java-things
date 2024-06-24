package Leetcode;

import java.util.*;

public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    public static class TreeNode {
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

    static TreeNode constructBinaryTree(Integer[] parentArray) {
        if (parentArray == null || parentArray.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(parentArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (index < parentArray.length && parentArray[index] != null) {
                current.left = new TreeNode(parentArray[index]);
                queue.add(current.left);
            }
            index++;

            if (index < parentArray.length && parentArray[index] != null) {
                current.right = new TreeNode(parentArray[index]);
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] parentArray = {2,1,1,1,3,null,null,null,null,null,1};
        TreeNode root = constructBinaryTree(parentArray);
        System.out.println(pseudoPalindromicPaths(root));
    }

    public static int res = 0;

    public static int pseudoPalindromicPaths(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        int t = res;
        res = 0;
        return t;
    }

    public static void solve(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null){
            list.add(root.val);
            if(isValid(list)) res++;
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        solve(root.left, list);
        solve(root.right, list);
        list.remove(list.size() - 1);
    }

    public static boolean isValid(List<Integer> arr){
        int n = arr.size();
        List<Integer> tmp = new ArrayList<>(arr);
        Collections.sort(tmp);
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[n];
        return perm(vis, n, tmp, list);
    }

    public static boolean perm(boolean[] vis, int n, List<Integer> arr, List<Integer> list){
        if (list.size() == n) {
            System.out.println(list);
            return isPalindrome(list, 0, n - 1);
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++){
            if (!vis[i] && !hs.contains(arr.get(i))){
                vis[i] = true;
                hs.add(arr.get(i));
                list.add(arr.get(i));
                if (perm(vis, n, arr, list)) return true;
                vis[i] = false;
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    public static boolean isPalindrome(List<Integer> list, int s, int e){
        while (s < e) {
            if (!list.get(s++).equals(list.get(e--))) return false;
        }

        return true;
    }

    public int pseudoPalindromicPaths2(TreeNode root) {
        int[] freq = new int[10];
        solve2(root, freq);
        int t = res;
        res = 0;
        return t;
    }

    public static void solve2(TreeNode root, int[] freq){
        if (root == null) {
            return;
        }

        freq[root.val]++;

        if (root.left == null && root.right == null){
            if (isPalindrome(freq)) res++;
            return;
        }

        solve2(root.left, freq);
        solve2(root.right, freq);
        freq[root.val]--;
    }

    private static boolean isPalindrome(int[] freq) {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] % 2 != 0) cnt++;
        }

        return cnt <= 1;
    }
}
