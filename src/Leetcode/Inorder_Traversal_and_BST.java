package Leetcode;

public class Inorder_Traversal_and_BST {
    static int isRepresentingBST(int arr[], int N){
        for (int i = 0; i < N; i++) {
            if (arr[i] > arr[i + 1]) return 0;
        }
        return 1;
    }
}
