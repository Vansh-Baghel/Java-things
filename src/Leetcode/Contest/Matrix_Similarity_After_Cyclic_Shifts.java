package Leetcode.Contest;

public class Matrix_Similarity_After_Cyclic_Shifts {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};
        int[] array3 = {6, 3, 6, 3};

        int[][] matrix = {array1, array2, array3};
        System.out.println(areSimilar(matrix, 3));
    }
    static boolean areSimilar(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;

        int[][] res = new int[n][m];

        k = k % m;

        for (int r = 0; r < n; r++){
            for (int c = 0; c < m; c++){
                // Odd
                if (r % 2 == 1) res[r][c] = mat[r][(c+k)%m];

                    // Even
                else res[r][c] = mat[r][((m-k)+c)%m];
            }
        }

        for (int[] row : res) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int r = 0; r < n; r++){
            for (int c = 0; c < m; c++){
                if (res[r][c] != mat[r][c]) return false;
            }
        }
        return true;
    }
}
