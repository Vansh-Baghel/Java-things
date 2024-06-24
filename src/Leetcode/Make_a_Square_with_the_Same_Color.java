package Leetcode;

public class Make_a_Square_with_the_Same_Color {
    public static void main(String[] args) {
        char[][] grid = {
                {'W', 'B', 'B'},
                {'W', 'W', 'B'},
                {'W', 'B', 'B'}
        };

        System.out.println(canMakeSquare(grid));
    }

    public static boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++){
            int b = 0, w = 0;

            for (int j = 0; j < 2; j++){
                if (grid[i][j] == 'W') w++;
                else b++;

                if (grid[i+1][j] == 'W') w++;
                else b++;

                if (grid[i][j+1] == 'W') w++;
                else b++;

                if (grid[i+1][j+1] == 'W') w++;
                else b++;

                if (Math.abs(w-b) >= 2) return true;
            }
        }

        return false;
    }
}
