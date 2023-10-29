package Leetcode;

public class Happy_days {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveHappyDays(arr));
    }

    private static int findMaxConsecutiveHappyDays(int[] days) {
        int maxi = 0;
        int cnt = 0;

        for (int day : days) {
            if (day == 1) {
                cnt++;
            } else {
                maxi = Math.max(maxi, cnt);
                cnt = 0;
            }
        }

        maxi = Math.max(maxi, cnt);

        return maxi;
    }
}
