package Leetcode;

public class Zigzag_Conversion {
    static String convert(String s, int numRows) {
        int i = 0, n = s.length();
        StringBuilder res = new StringBuilder();
        StringBuffer[] sb = new StringBuffer[numRows];

        for (int j = 0; j < numRows; j++) {
            sb[j] = new StringBuffer();
        }

        while (i < n){
            for (int idx = 0; idx < numRows && i < n; idx++) {
                sb[idx].append(s.charAt(i++));
            }
            for (int idx = numRows - 2; idx >= 1 && i < n; idx--) {
                sb[idx].append(s.charAt(i++));
            }
        }

        for (StringBuffer str: sb){
            res.append(str);
        }

        return res.toString();
    }
}
