package Leetcode;

public class Largest_subsquare_surrounded_by_X {
    public static void main(String[] args) {
        int n = 2; // size of the matrix
        char[][] a = {
                {'X', 'X'},
                {'X', 'X'}
        };

        System.out.println(largestSubsquare(n, a));
    }

    static int largestSubsquare(int n, char a[][]) {
        // code here
        int[][] hPrefix = new int[n][n], vPrefix = new int[n][n];
        int res = 0;

        for (int i = 0; i < n; i++){
            int rCount = 0, cCount = 0;
            for (int j = 0; j < n; j++){
                rCount = a[i][j]=='X'?++rCount:0;
                cCount = a[j][i]=='X'?++cCount:0;

                hPrefix[i][j] = rCount;
                vPrefix[j][i] = cCount;
            }
        }

        for (int i = n - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                int size = Math.min(hPrefix[i][j], vPrefix[i][j]);

                while (size > res){
                    if (hPrefix[i-size+1][j] >= size && vPrefix[i][j-size+1] >= size) {
                        res=size;
                    } else size--;
                }
            }
        }

        return res;
    }
}
