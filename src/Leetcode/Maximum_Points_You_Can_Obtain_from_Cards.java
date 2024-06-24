package Leetcode;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int mini = Integer.MAX_VALUE, n = cardPoints.length, totalSum = 0, curSum = 0, s = 0;

        for (int e = 0; e < n; e++){
            totalSum += cardPoints[e];
            curSum += cardPoints[e];

            if (n - k == e - s + 1){
                mini = Math.min(mini, curSum);
                curSum -= cardPoints[s];
                s++;
            }
        }

        if (k == n) return totalSum;

        return totalSum - mini;
    }
}
