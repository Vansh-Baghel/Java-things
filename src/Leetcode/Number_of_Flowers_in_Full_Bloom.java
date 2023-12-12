package Leetcode;

import java.util.Arrays;

public class Number_of_Flowers_in_Full_Bloom {
    public static void main(String[] args) {
        int[][] flowers = {
                {1, 6},
                {3, 7},
                {9, 12},
                {4, 13}
        };

        int[] people = {2, 3, 7, 11};

        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }

    static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int maxi = 0;

        for(int[] flower: flowers){
            int end = flower[1];

            maxi = Math.max(end, maxi);
        }

        int[] arr = new int[maxi];
        int idx = 0;
        int[] ans = new int[people.length];

        for(int[] flower: flowers){
            int start = flower[0];
            int end = flower[1];

            for (int i = start-1; i < end; i++) {
                arr[i]++;
            }
        }

        for (int num: people){
            if (num > maxi) {
                ans[idx++] = 0;
            } else ans[idx++] = arr[num - 1];
        }

        return ans;
    }

    static int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int n = flowers.length, idx1=0, idx2 = 0;
        int[] bloom = new int[n+1], dead = new int[n+1], ans = new int[people.length];

        for(int[] flower: flowers){
            int start = flower[0];
            int end = flower[1];

            bloom[idx1++] = start;
            dead[idx2++] = end;
        }

        Arrays.sort(bloom);
        Arrays.sort(dead);

        for (int i = 0; i < people.length; i++) {
            int a = findBloom(bloom, dead, people[i]);
            int b = findDead(bloom, dead, people[i]);

            ans[i] = a - b;
        }

        return ans;
    }

    static int findBloom(int[] bloom, int[] dead, int personPosition) {
        int s = 0, e = bloom.length - 1, bloomTime = 0;

        while (s <= e){
            int m = s + (e - s) / 2;

            if (bloom[m] <= personPosition){
                bloomTime = m + 1;
                s = m + 1;
            } else e = m - 1;
        }

        return bloomTime;
    }

    static int findDead(int[] bloom, int[] dead, int personPosition) {
        int s = 0, e = bloom.length - 1, deadTime = 0;

        while (s <= e){
            int m = s + (e - s) / 2;

            if (dead[m] < personPosition) {
                deadTime = m + 1;
                s = m + 1;
            } else e = m - 1;
        }
        return deadTime;
    }
}
