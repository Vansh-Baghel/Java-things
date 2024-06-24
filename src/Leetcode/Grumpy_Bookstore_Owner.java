package Leetcode;

public class Grumpy_Bookstore_Owner {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unsatisfied = 0, res = 0, n = customers.length;

        for (int i = 0; i < minutes; i++){
            if (grumpy[i] == 1) unsatisfied += customers[i];
        }

        res = unsatisfied;

        int s = 0, e = minutes;

        // Running a slider window of fixed size as that of minutes, because it can only be consequetive
        while (e < n){
            if (grumpy[e] == 1) {
                unsatisfied += customers[e];
            }
            if (grumpy[s] == 1) {
                unsatisfied -= customers[s];
            }

            res = Math.max(unsatisfied, res);

            e++;
            s++;
        }

        for (int i = 0; i < n; i++){
            if (grumpy[i] == 0) res += customers[i];
        }

        return res;
    }
}
