package Leetcode;

import java.util.*;

public class Mice_and_Cheese {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = reward1.length;
        int res = 0;

        // res mai reward2 ka total nikala because mouse 2 can eat any number of cheese, only mouse 1 can eat k number of cheese.
        for (int i = 0; i < n; i++){
            res += reward2[i];
            // Storing difference so that we could further add the top k elements of reward1

            // Storing difference so that we could further add the top k elements of reward1.
            // And difference isiliye liya because reward1 se agar difference zyada hua matlab reward2 chhota hoga, and small hai toh avoid bhi hojayega uska index, which will make the answer more bigger.
            pq.add(reward1[i] - reward2[i]);
        }

        for (int i = 0; i < k; i++){
            res += pq.poll();
        }

        return res;
    }

    public int miceAndCheese2(int[] reward1, int[] reward2, int k) {
        int n = reward1.length, res = 0;
        int[][] r1 = new int[n][2];

        for (int i = 0; i < n; i++){
            r1[i] = new int[]{reward1[i]-reward2[i], i};
        }

        Arrays.sort(r1, (a, b) -> b[0] - a[0]);

        // Because, after sorting the positive numbers will be on the left, and negative on the right. If positive, means those nums of reward1 are greater than that of reward2. If negative, means reward2 greater.
        for (int i = 0; i < k; i++){
            res+=reward1[r1[i][1]];
        }

        for (int i = k; i < n; i++){
            res+=reward2[r1[i][1]];
        }

        return res;
    }
}
