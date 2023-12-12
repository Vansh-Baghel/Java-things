package Leetcode;

import java.util.*;

public class Check_if_string_is_rotated_by_two_places {
    public static void main(String[] args) {
        System.out.println(isRotated("daxjheq", "eqdaxjh"));
    }

    public static boolean isRotated(String str1, String str2) {
        String s3 = str1 + str1;
        int n = s3.length(), m = str2.length();

        for (int i = 0; i < n-m; i++) {
            String subStr= s3.substring(i, m);
            if (subStr.equals(str2)){
                return true;
            }
        }
        return false;
    }
}
