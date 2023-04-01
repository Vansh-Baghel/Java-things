//https://leetcode.com/problems/gas-station/
package Leetcode;

public class Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int startPoint = 0;
        int sumForStartPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
//            Cannot use this condition because if the next element in cost is high, then car will not be able to move to next gas station.
//            if (visited == 1 && gas[i] > cost[i]){
//                startPoint = i;
//                visited--;
//            }
            sumForStartPoint += gas[i] - cost[i];
//            Whenever the sum goes from negative to positive, that means that -ve element index could be the start point. If it never becomes +ve, then it means that cost > gas therefore will return -1.
            if (sumForStartPoint < 0) {
                startPoint = i + 1;
                sumForStartPoint = 0;
            }
        }
        return (totalSum >= 0 ? startPoint : -1);
    }
}
