package Leetcode;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        int ans = 0;
        int[] newArr = new int[s.length()];

        for(int i = 0; i < s.length(); i++){
        switch (s.charAt(i)){
            case 'I':
                newArr[i] = 1;
                break;
            case 'V':
                newArr[i] = 5;
                break;
            case 'X':
                newArr[i] = 10;
                break;
            case 'L':
                newArr[i] = 50;
                break;
            case 'C':
                newArr[i] = 100;
                break;
            case 'D':
                newArr[i] = 500;
                break;
            case 'M':
                newArr[i] = 1000;
                break;
        }
        }

        for (int i = 0; i < newArr.length; i++) {
            if(newArr[i] < newArr[i + 1]){
            // As all the further nums are greater than previous except in 8 steps,
                ans -= newArr[i];
            } else ans += newArr[i];
        }

        return ans;
    }
}
