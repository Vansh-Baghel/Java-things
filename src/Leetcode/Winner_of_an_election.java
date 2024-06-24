package Leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Winner_of_an_election {
    static class Pair{
        String str;
        int cnt;
        public Pair(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static String[] winner(String arr[], int n) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        HashMap<String, Integer> hm = new HashMap<>();
        String[] res = new String[2];

        for (String str: arr) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Pair top = maxHeap.poll();
        String resStr = "", resCnt = "";

        while(!maxHeap.isEmpty()){
            Pair temp = maxHeap.poll();
            String tempStr = temp.str;
            int tempCnt = temp.cnt;
            String topStr = top.str;
            int topCnt = top.cnt;

            if (topCnt > tempCnt) {
                res[0] = topStr;
                res[1] = topCnt + "";
                return res;
            }
            // Agar equal hua then
            else {
                if (isTopStrSmaller(topStr, tempStr)) {
                    resStr = topStr;
                    resCnt = topCnt + "";
                } else {
                    resStr = tempStr;
                    resCnt = tempCnt + "";
                    top = temp;
                }
            }
        }

        res[0] = resStr;
        res[1] = resCnt + "";

        return res;
    }

    private static boolean isTopStrSmaller(String str1, String str2) {
        return str1.compareTo(str2) < 0;
    }

    public static String[] winner2(String arr[], int n) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String str: arr) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        String resStr = "";
        int resCnt = 0;

        for (var top: hm.entrySet()){
            String curStr = top.getKey();
            int curCnt = top.getValue();

            if (resCnt < curCnt) {
                resCnt = curCnt;
                resStr = curStr;
            } else if (resCnt == curCnt && curStr.compareTo(resStr) < 0){
                resStr = curStr;
            }
        }

        return new String[]{resStr, resCnt + ""};
    }
}
