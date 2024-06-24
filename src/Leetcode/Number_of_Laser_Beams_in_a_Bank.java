package Leetcode;

public class Number_of_Laser_Beams_in_a_Bank {
    static int numberOfBeams(String[] bank) {
        int prevProd = 0, res = 0;

        for (String s : bank) {
            int curOnes = cntOnes(s);

            if (prevProd == 0) {
                prevProd = curOnes;
            }
            else if (curOnes != 0) {
                curOnes = cntOnes(s);
                res += curOnes * prevProd;
                prevProd = curOnes;
            }
        }

        return res;
    }

    private static int cntOnes(String s) {
        int cnt = 0;
        for (char ch: s.toCharArray()) if (ch == '1') cnt++;

        return cnt;
    }
}
