//https://leetcode.com/problems/invert-binary-tree/submissions/876008645/
package Leetcode;

public class Invert_Binary_Tree {

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
    public TreeNode invertTree(TreeNode root) {
        // Whenever root null hua toh it'll return the root format jo existing hai, and when root null hoga only then recursion of left will change to recursion of right.
        if (root == null) return root;

        // First left ke bottom mai reach hoga ie from root to left
        TreeNode left = invertTree(root.left);

        // Then it'll store right.
        TreeNode right = invertTree(root.right);

        // Jab left and right are stored then it'll return to its root ie 2 here and then both 1 and 3 will be swapped. Then from 2 it'll traverse 4 to right and so on.
        root.right = left;
        root.left = right;

//      We are returning root and not printing it because we just need to change the order and not add or remove anything
        return root;
    }
}
