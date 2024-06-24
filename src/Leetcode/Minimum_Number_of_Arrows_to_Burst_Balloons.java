package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Number_of_Arrows_to_Burst_Balloons {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        System.out.println(findMinArrowShots(intervals));
    }

    static int findMinArrowShots(int[][] points) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.second < b.second)
                    return -1;
                return 1;
            }
        });

        int cnt = 1;

        for (int[] point : points) {
            minHeap.add(new Pair(point[0], point[1]));
        }

        Pair top = minHeap.poll();
        int maxEnd = top.second;

        while (!minHeap.isEmpty()) {
            Pair tempTop = minHeap.poll();
            int tempFirst = tempTop.first;
            int tempSec = tempTop.second;

            if (tempFirst <= maxEnd){
                continue;
            }
            else {
                cnt++;
                maxEnd = tempSec;
            }
        }

        return cnt;
    }

    static int findMinArrowShots2(int[][] points) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.second < b.second)
                    return -1;
                return 1;
            }
        });

        int cnt = 0;

        for (int[] point: points){
            minHeap.add(new Pair(point[0], point[1]));
        }

        while (!minHeap.isEmpty()){
            Pair top = minHeap.poll();
            int maxEnd = top.second;

            while (!minHeap.isEmpty() && minHeap.peek().first <= maxEnd){
                minHeap.poll();
            }
            cnt++;
        }

        return cnt;
    }
}
