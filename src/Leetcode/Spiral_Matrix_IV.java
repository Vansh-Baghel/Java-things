//https://leetcode.com/problems/spiral-matrix-iv/
package Leetcode;

public class Spiral_Matrix_IV {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (head != null){
                for (int i = left; i <= right && head != null; i++) {
                    mat[top][i] = head.val;
                    head = head.next;
                }
                top++;
                for (int i = top; i <= bottom && head != null; i++) {
                    mat[i][right] = head.val;
                    head = head.next;
                }
                right--;
                for (int i = right; i >= left && head != null; i--) {
                    mat[bottom][i] = head.val;
                    head = head.next;
            }
                bottom--;
                for (int i = bottom; i >= top && head != null; i--) {
                    mat[i][left] = head.val;
                    head = head.next;
            }
                left++;
        }
        return mat;
    }
}
