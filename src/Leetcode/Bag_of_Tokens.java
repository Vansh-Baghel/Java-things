package Leetcode;

import java.util.Arrays;

public class Bag_of_Tokens {
    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;

        System.out.println(bagOfTokensScore(tokens, power));
    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int s = 0, n = tokens.length, e = n - 1;
        int score = 0;

        while (s <= e){
            if (power >= tokens[s]){
                power -= tokens[s];
                score++;
                s++;
            } else {
                if (score > 0 && s < e && power + tokens[e] >= tokens[s]) {
                    score--;
                    power += tokens[e];
                    e--;
                } else break;
            }
        }

        return score;
    }
}
