package Leetcode;

import java.util.Arrays;

public class Construct_Smallest_Number_From_DI_String {
    public static void main(String[] args) {

        System.out.println(smallestNumber("IIIDIDDD"));
    }

    static String smallestNumber(String pattern) {
        int arrLength = pattern.length() + 1;
        int[] arr = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
//            Adding numbers in array based on the length of the string.
            arr[i] = i + 1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            int temp = i;

            while (temp < pattern.length() && pattern.charAt(temp) == 'D'){
                // Here if D comes 3 times then temp would increase by 3, ie, if i = 5 then temp = 8.

                temp++;
            }

            reverse(i, temp , arr);

            if (temp != i) i = temp - 1;

        }
        return Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
    }
    static void reverse(int i ,int j , int[] arr){
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
