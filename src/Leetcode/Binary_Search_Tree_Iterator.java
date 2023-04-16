package Leetcode;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.Stack;

public class Binary_Search_Tree_Iterator{
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

// TreeNode type of stack
    private Stack<TreeNode> stack = new Stack<>();

    public void pushIntoStack(TreeNode root){
        while (root != null){
//            Pushing the root.
            stack.push(root);
//        Adding all the elements left to it.
            root = root.left;
        }
    }

    public Binary_Search_Tree_Iterator(TreeNode root) {
//        This will go to that function which will add all the left nodes.
        pushIntoStack(root);
    }

    public int next() {
//        Taking out the topmost node which was added. Storing top stack's node in tempNode so that it doesn't get mismatched with the newly added right nodes.
        TreeNode tempNode = stack.pop();
//        Pushing the right node if it exists and in that function, it will push all the left nodes which follows the inorder.
        if (tempNode.right != null) pushIntoStack(tempNode.right);
//        Returning the stored value.
        return tempNode.val;
    }

    public boolean hasNext() {
        // If stack is empty, then hasNext would be false.
        return !stack.isEmpty();
    }
}
