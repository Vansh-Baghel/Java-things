package Leetcode;

public class Predict_the_Column {
    int columnWithMaxZeros(int arr[][], int N) {
        int cnt = 0, maxi=0, maxIdx = 0;

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                if (arr[r][c] == 0) {
                    cnt++;
                }
                if (cnt == N) return c;
            }
            if (maxi < cnt) {
                maxi = cnt;
                maxIdx = c;
            }
            cnt=0;
        }
        return maxi == 0 ? -1 : maxIdx;
    }
}
