package Recursion;
import java.util.*;

public class Playlist_L7 {
    public static void main(String[] args) {
            int[] arr = {1,1,1};
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<List<Integer>> parentList = new ArrayList<>();

            int sumCalc=0;

        seqWithSumK(2, 0,arr, list,parentList, sumCalc);

        System.out.println(parentList);
    }

    static void seqWithSumK(int k, int i, int[] arr, ArrayList<Integer> list, ArrayList<List<Integer>> parentList, int sumCalc){
        if (i == arr.length){
            if (k == sumCalc){
                parentList.add(new ArrayList<>(list));
            }
            return;
        }

        if (k < sumCalc){
            return;
        }

        sumCalc+=arr[i];
        list.add(arr[i]);

        seqWithSumK(k,i+1,arr,list,parentList, sumCalc);

        sumCalc-=arr[i];
        list.remove(list.size() - 1);

        seqWithSumK(k,i+1,arr,list,parentList, sumCalc);
    }

    static boolean seqWithOnly1SumK(int k, int i, int[] arr, ArrayList<Integer> list, ArrayList<List<Integer>> parentList, int sumCalc){
        if (i == arr.length){
            if (k == sumCalc){
                parentList.add(new ArrayList<>(list));
                return true;
            }
            return false;
        }

        sumCalc+=arr[i];
        list.add(arr[i]);

        if (seqWithOnly1SumK(k,i+1,arr,list,parentList, sumCalc)) return true;

        sumCalc-=arr[i];
        list.remove(list.size() - 1);

        if(seqWithOnly1SumK(k,i+1,arr,list,parentList, sumCalc)) return true;

        return false;
    }
}
