//https://leetcode.com/problems/furthest-point-from-origin/submissions/
package Leetcode.Contest;

public class Leetcode_1 {
    public int furthestDistanceFromOrigin(String moves) {
        int leftC = 0;
        int rightC = 0;
        int blankC = 0;

        char[] arr = moves.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'L') leftC++;
            else if (arr[i] == 'R') rightC++;
            else blankC++;
        }

        return Math.abs(leftC - rightC) + blankC;
    }
}
