package Leetcode.Contest;

public class Time_Needed_to_Buy_Tickets {
    public static void main(String[] args) {
        int[] arr = {15,66,3,47,71,27,54,43,97,34,94,33,54,26,15,52,20,71,88,42,50,6,66,88,36,99,27,82,7,72};
        System.out.println(timeRequiredToBuy(arr, 18));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0, n = tickets.length, totalMin = 0;

        for (int ticket : tickets) {
            if (ticket <= tickets[k]) {
                res += ticket;
                totalMin++;
            }
        }

        res += (n - totalMin) * tickets[k];

        for (int i = k + 1; i < n; i++) {
            if (tickets[i] >= tickets[k]) res--;
        }

        return res;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int total = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]);
            } else {
                total += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return total;

    }
}
