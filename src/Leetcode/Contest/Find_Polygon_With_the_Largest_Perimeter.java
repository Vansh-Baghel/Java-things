package Leetcode.Contest;

import java.util.PriorityQueue;

public class Find_Polygon_With_the_Largest_Perimeter {
    public long largestPerimeter(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long totalSum = 0;

        for(int num: nums){
            maxHeap.add(num);
            totalSum += num;
        }

        while (!maxHeap.isEmpty()){
            int top = maxHeap.poll();
            totalSum -= top;

            if (totalSum > top){
                return totalSum + top;
            }
        }

        return -1;
    }
}
