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
        // Setting all the blocks of mat as -1, so when the head becomes null and if any blocks are left, then we can get -1 as its value.
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
            // printing from left to right
            for (int i = left; i <= right && head != null; i++) {
                mat[top][i] = head.val;
                head = head.next;
            }
            // Increasing top value as we already printed the top row. So next time it starts from new line.
            top++;
            // printing from top to bottom
            for (int i = top; i <= bottom && head != null; i++) {
                mat[i][right] = head.val;
                head = head.next;
            }
            right--;
            // printing from right to left
            for (int i = right; i >= left && head != null; i--) {
                mat[bottom][i] = head.val;
                head = head.next;
            }
            bottom--;
            // printing from bottom to top
            for (int i = bottom; i >= top && head != null; i--) {
                mat[i][left] = head.val;
                head = head.next;
            }
            left++;
        }

        return mat;
    }
}
