package Leetcode;

import java.util.ArrayList;

public class Best_Time_to_Buy_and_Sell_Stock_CodingNinjas {
    public static ArrayList<Integer> convertIntArrayToArrayList(int[] array) {
        // Create an ArrayList<Integer>
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Iterate through the int array and add each element to the ArrayList
        for (int num : array) {
            arrayList.add(num);
        }

        // Return the ArrayList
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        int[] intArray = {17,20,11,9,12,6};

        // Call the function to convert int[] to ArrayList<Integer>
        ArrayList<Integer> arrayList = convertIntArrayToArrayList(intArray);

        System.out.println(maximumProfit(arrayList));
    }

    public static int maximumProfit(ArrayList<Integer> prices) {
        int n = prices.size();
        int mini = prices.get(0);
        int dif = 0;

        for (int i = 1; i < n; i++) {
            int num = prices.get(i);
            dif = Math.max(dif,num - mini);
            mini = Math.min(mini, prices.get(i));
        }
        return dif;
    }
}
