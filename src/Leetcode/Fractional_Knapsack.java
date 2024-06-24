package Leetcode;

import java.util.*;

public class Fractional_Knapsack {
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class Pair{
        double val;
        int wt;

        Pair(double val, int wt){
            this.val = val;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int[] inputValues = {6,2,8,6};
        int[] inputWeights = {10,9,8,3};

        // Create an array of Item objects
        Item[] arr = new Item[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            arr[i] = new Item(inputValues[i], inputWeights[i]);
        }

        System.out.println(fractionalKnapsack(5, arr, arr.length));
    }

    static double fractionalKnapsack(int W, Item arr[], int n){
        double res = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(pair -> -pair.val));

        for (int i = 0; i < n; i++){
            double val = (double)(arr[i].value / arr[i].weight);
            pq.add(new Pair(val, arr[i].weight));
        }

        while (!pq.isEmpty() && W >= 0){
            Pair top = pq.poll();
            double val = top.val;
            int wt = top.wt;

            if (wt <= W){
                res+= val * wt;
                W -= wt;
            } else {
                res += val * W;
                break;
            }
        }

        return res;
    }
}
