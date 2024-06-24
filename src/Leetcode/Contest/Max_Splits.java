package Leetcode.Contest;

public class Max_Splits {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("lee(tcod(e(");
        str.deleteCharAt(3);
        System.out.println(maxSplits("repxcpkt", "eprpctkx"));
    }

    public static int maxSplits(String s, String t) {
        // code here
        int i = 0, res = 0, n = s.length();

        while (i < n){
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if (ch1 != ch2) {
                int[] f1 = new int[26];
                int[] f2 = new int[26];

                f1[ch1 - 'a']++;
                f2[ch2 - 'a']++;
                i++;

                while (i < n && !isEqual(f1, f2)) {
                    ch1 = s.charAt(i);
                    ch2 = t.charAt(i);
                    f1[ch1 - 'a']++;
                    f2[ch2 - 'a']++;
                    i++;
                }

                i--;
            }
            res++;
            i++;
        }

        return res;
    }

    public static boolean isEqual(int[] f1, int[] f2){
        for (int i = 0; i < 26; i++){
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }
}
