package Leetcode;

public class Climb_Stairs {
    public static void main(String[] args) {

    }

    static int climbStairs(int n){
        //         This array will store the number of ways to climb the stairs starting from 0.
        int[] stepFor = new int[n + 1];
//         These represent that how many steps will be req to climb stairs 0 and 1 respectively.
        stepFor[0] = 1;
        stepFor[1] = 1;

        for(int i = 2 ; i <= n ; i++){
//             To get the step for nth step , we need to find the steps for last 2 stairs.
            stepFor[i] = stepFor[i - 1] + stepFor[i - 2];
        }

        return stepFor[n];
    }
}
