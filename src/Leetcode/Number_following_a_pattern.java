package Leetcode;

public class Number_following_a_pattern {
    public static void main(String[] args) {
        System.out.println(printMinNumberForPattern("IIDDDII"));
    }

    static String printMinNumberForPattern(String S){
        int n=S.length();
        int[] arr = new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int strt = i;
           while (strt < n && S.charAt(strt) == 'D') strt++;
           if (strt!=i) reverse(i,strt,arr);
           if (i!=strt) i = strt;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            ans.append(arr[i]);
        }

        return ans.toString();
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
