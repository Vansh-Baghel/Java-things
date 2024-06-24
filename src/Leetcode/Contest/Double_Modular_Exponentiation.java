package Leetcode.Contest;

import java.util.*;

public class Double_Modular_Exponentiation {
    public static void main(String[] args) {
        int[][] var = {{6,8,1,53}};

        System.out.println(getGoodIndices(var, 1));
    }

    static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];

            int n1 = 1;

            for (int j = 0; j < b; j++) {
                n1 = (n1 * a) % 10;
            }

            int n2 = 1;

            for (int j = 0; j < c; j++) {
                n2 = (n1 * n2) % m;
            }

            if (n2 == target) res.add(i);
        }

        return res;
    }
}

