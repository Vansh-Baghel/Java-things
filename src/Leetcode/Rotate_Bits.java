package Leetcode;

import java.util.*;

public class Rotate_Bits {
    public static void main(String[] args) {
        System.out.println(rotate(29, 2));
    }

    static ArrayList<Integer> rotate(int N, int D){
        int leftSum = 0;
        int rightSum = 0;
        int[] arr = new int[16];
        D = D % 16;

        for (int i = 0; i < 16; i++) {
            // Means will check from behind and aage add krte jaayenge. Example N = 7, bits => 111, arr => [1,1,1,0,0----]
            arr[i] = (N & 1) == 1 ? 1 : 0;
            N /= 2;
        }

        int j = 0;
        int leftIdx = (16-D)%16;
        // RightShift mai D will be the element index as well from the end.
        // EG: b3,b2,b1,b0. For D = 1, b0,b3,b2,b1. For D = 2, b1,b0,b3,b2.
        int rightIdx = D;

        while (j < 16){
            // Matlab in bits agar 1 hai toh add its sum in the leftSum.
            if (arr[leftIdx] == 1){
                leftSum += 1 << j;
            } if (arr[rightIdx] == 1){
                rightSum += 1 << j;
            }

            // % 16 is needed because leftIdx and rightIdx are dependend of D, and if size D = 17, then it will simply mean 1 because we are taking the array as cycle, like if 1 is at the rightmost index, then D = 1 will make it the first index.
            leftIdx = (leftIdx + 1) % 16;
            rightIdx = (rightIdx + 1) % 16;
            j++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(leftSum);
        list.add(rightSum);
        return list;
    }
}
