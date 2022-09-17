package Recursion.Arrays;

import java.util.ArrayList;

public class GetAllTargetElements {
    public static void main(String[] args) {
        int[] arr = {1,3,5,5,6};
//        Created arraylist because we want to keep adding the numbers in the array which couldn't be done with normal array.
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(findAllIndex(arr , 5, 0 , list));
    }

    static ArrayList<Integer> findAllIndex(int[] arr , int target , int index , ArrayList<Integer> list){
        if (index == arr.length - 1){
            return list;
        }

        if (arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr , target, index + 1 , list);
    }
}
