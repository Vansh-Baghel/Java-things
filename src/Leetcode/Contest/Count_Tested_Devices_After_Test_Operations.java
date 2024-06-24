package Leetcode.Contest;

public class Count_Tested_Devices_After_Test_Operations {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;

        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - res > 0) {
                res++;
            }
        }
        return res;
    }

    public int countTestedDevices2(int[] batteryPercentages) {
        int n = batteryPercentages.length, res = 0;

        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                res++;
                for (int j = 0; j < n; j++) {
                    batteryPercentages[j]--;
                }
            }
        }
        return res;
    }
}
