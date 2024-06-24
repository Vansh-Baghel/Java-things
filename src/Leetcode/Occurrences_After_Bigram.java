package Leetcode;

import java.util.*;

public class Occurrences_After_Bigram {
    public static void main(String[] args) {
        String txt = "alice is a good girl she is a good student", first = "a", second = "good";

        System.out.println(Arrays.toString(findOcurrences(txt, first, second)));
    }

    static String[] findOcurrences(String text, String first, String second) {
        Queue<String> q = new LinkedList<>();

        String[] str = text.split(" ");
        int n = str.length;

        for (int i = 0; i < n - 2; i++){
            String cur = str[i];
            String nxt = str[i + 1];
            if (cur.equals(first) && nxt.equals(second)) q.add(str[i+2]);
        }

        String[] res = new String[q.size()];
        int idx = 0;
        while (!q.isEmpty()) res[idx++] = q.poll();

        return res;
    }

    public String[] findOcurrences2(String text, String first, String second) {
        List<String> res = new ArrayList<>();

        String[] str = text.split(" ");
        int n = str.length;

        for (int i = 0; i < n - 2; i++){
            String cur = str[i];
            String nxt = str[i + 1];
            if (cur.equals(first) && nxt.equals(second)) res.add(str[i+2]);
        }

        return res.toArray(new String[0]);
    }
}
