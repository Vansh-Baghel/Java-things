package Recursion.Arrays;

public class TargetInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {6 , 7, 9 , 1 , 3, 4 ,5};
        int target = 3;
        int ans = recursiveRotatedArray(arr , target , 0 , arr.length - 1);
        System.out.println(ans);
    }

    static int recursiveRotatedArray(int[] arr , int target , int s , int e){
        if (s > e){
            return -1;
        }

        int m = s + (e - s)/2;
        if (target == arr[m]){
            return m;
        }
        if (arr[s] <= arr[m]){
            if (target >= arr[m] && target <= arr[s]){
                return recursiveRotatedArray(arr , target , m + 1 , e);
            }
            return recursiveRotatedArray(arr , target , s , m - 1);
        }

        if (target >= arr[m] && target <= arr[e]){
            return recursiveRotatedArray(arr , target , m + 1 , e);
        }
        return recursiveRotatedArray(arr , target , s , m - 1);
    }
}
