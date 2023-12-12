package Leetcode;

import java.util.*;

public class Maximize_the_Confusion_of_an_Exam {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("FFFTTFTTFT", 3));
    }

    static int maxConsecutiveAnswers(String answerKey, int k) {
        int s = 0, n = answerKey.length(), res = 0;
        int[] count = new int[2];

        for (int e = 0; e < n; e++) {
            char cur = answerKey.charAt(e);

            if (cur == 'F') count[0]++;
            else count[1]++;

            if (Math.min(count[0], count[1]) > k) {
                char stChar = answerKey.charAt(s);

                if (stChar == 'F') count[0]--;
                else count[1]--;

                s++;
            }

            res = Math.max(res, (e - s) + 1);
        }

        return res;
    }
}
