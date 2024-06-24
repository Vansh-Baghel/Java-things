package Leetcode;

public class Distribute_candies_in_a_binary_tree {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    static int count = 0;

    static int distributeCandy(Node root){
        //code here
        solve (root);
        int tmp = count;
        count = 0;
        return tmp;
    }

    static int solve(Node root){
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        // Math.abs because if the leaf node is 0, toh upar jaate waqt it will return -1,
        // which means that it requires 1 candy, isiliye abs lelo
        count += Math.abs(left) + Math.abs(right);

        return (left + right + root.data) - 1;
    }
}
