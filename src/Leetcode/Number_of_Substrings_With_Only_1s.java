package Leetcode;

public class Number_of_Substrings_With_Only_1s {
    public int numSub(String s) {
        int n = s.length(), res = 0, e = 0, mod = (int)(1e9 + 7);

        while (e < n){
            int cur = 0, ones = 0;
            while (e < n && s.charAt(e) == '1'){
                ones++;
                cur = (cur + ones) % mod;
                e++;
            }
            res = (res + cur) % mod;
            e++;
        }

        return res;
    }

    public int numSub2(String s) {
        int n = s.length(),  e = 0, mod = (int)(1e9 + 7);
        long res = 0;

        while (e < n){
            if (s.charAt(e) == '1') {
                long tmp = 0;

                while (e < n && s.charAt(e) == '1'){
                    e++;
                    tmp++;
                }

                res+= (tmp * (tmp + 1)) / 2;
            }
            e++;
        }

        return (int)(res % mod);
    }
}
