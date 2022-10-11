//https://leetcode.com/problems/roman-to-integer/
package Leetcode;

public class Roman_Numbers {
    public static void main(String[] args) {

    }

    static int romanToInt(String s){
        int nums[]=new int[s.length()];
//         This for loop will form a complete array of nums which will include all the values of the roman numbers.
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum = 0;
//         Now , nums array is formed . Here , we are adding all the values . Note that all the numbers will be in ascending order of array , if its not , then just subtract the value from the sum.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]){
                sum-=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }
//         Since we are not watching the last element through loop , we need to add it manually .
        return sum + nums[nums.length - 1];
    }
}
