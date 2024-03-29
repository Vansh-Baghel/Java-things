package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Multiplications_to_reach_End {
    static class Pair{
        int stepCount;
        int product;

        Pair(int stepCount, int product){
            this.product=product;
            this.stepCount= stepCount;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};

        int ans = minimumMultiplications(arr, 7,66175);
        System.out.println(ans);
    }

    static int minimumMultiplications(int[] arr, int start, int end) {

        if (start == end) return 0;

        Queue<Pair> q = new LinkedList<>();
        int mod = 100000;
        int[] steps = new int[mod]; // Assuming maximum product is 999999

        Arrays.fill(steps, (int) 1e9);
        steps[start] = 0;

        q.add(new Pair(0, start));

        while (!q.isEmpty()){
            Pair top = q.poll();
            int prod = top.product;
            int cnt = top.stepCount;

            for (int j : arr) {
                int totalProduct = (j * prod) % mod;

                if (totalProduct == end) {
                    return cnt + 1;
                }

                if (steps[totalProduct] > cnt + 1) {
                    steps[totalProduct] = cnt + 1;
                    q.add(new Pair(cnt + 1, totalProduct));
                }
            }
        }
        return -1;
    }
}
