package Leetcode;

import java.util.*;

public class Sequential_Digits {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(58, 155));
    }

    static List<Integer> sequentialDigits(int low, int high) {
        StringBuilder tmp = new StringBuilder();
        List<Integer> res = new ArrayList<>();

        while (low <= high){
            String lowStr = Integer.toString(low);

            if (tmp.toString().equals("")){
                for (int i = lowStr.charAt(0) - '0'; i <= '9'; i++) {
                    if (tmp.length() == lowStr.length() && Integer.parseInt(tmp.toString()) <= high){
                        if (Integer.parseInt(tmp.toString()) >= low) res.add(Integer.parseInt(tmp.toString()));
                        tmp.deleteCharAt(0);
                    }

                    if (i==10) {
                        tmp = new StringBuilder();
                        break;
                    }

                    tmp.append(i);
                    if (Integer.parseInt(tmp.toString()) > high) return res;
                }
            }

            // This works same as pow.
            low = (int)Math.pow(10, lowStr.length());
        }

        return res;
    }

    static List<Integer> sequentialDigits2(int low, int high) {
        String str = "123456789";
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            for (int j = 0; i + j < 10; j++) {
                String tmp = str.substring(j, i + j);

                int num = Integer.parseInt(tmp);

                if (num >= low && num <= high) res.add(num);
            }
        }


        return res;
    }
}
