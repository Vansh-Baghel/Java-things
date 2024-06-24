package Leetcode;

import java.util.*;

public class Top_k_numbers_in_a_stream {
    public static class Pair{
        int num;
        int cnt;

        Pair(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        int N=5, K=4;
        int arr[] = {5, 2, 1, 3, 2};
        System.out.println(kTop(arr, N, K));
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        // We are just storing the nums in the pq, and we are cross chekcing the freq from the hm.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            // If the num ka freq are not equal, return the greater num.
            if(map.get(a)!=map.get(b))
                return map.get(b) - map.get(a);

                // Else return the smaller num.
            else
                return a - b;
        });

        ArrayList<Integer> temp = new ArrayList<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
            maxHeap = new PriorityQueue<>((a,b)->{
                if(map.get(a)!=map.get(b))
                    return map.get(b) - map.get(a);
                else
                    return a - b;
            });
            for(int key:map.keySet()){
                maxHeap.add(key);
            }
            int tempK = k;
            temp.clear();
            while(tempK>0 && !maxHeap.isEmpty()){
                int a = maxHeap.poll();
                temp.add(a);
                tempK--;
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
