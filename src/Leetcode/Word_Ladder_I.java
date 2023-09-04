package Leetcode;

import java.util.*;

public class Word_Ladder_I {
    static class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        int ans = wordLadderLength("der", "dfs", wordList);
        System.out.println(ans);
    }

    static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        HashSet<String> hs = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();

        hs.addAll(Arrays.asList(wordList));

        q.add(new Pair(startWord, 1));
        hs.remove(startWord);

        while (!q.isEmpty()){
            Pair top = q.poll();
            hs.remove(top.first);

            if (top.first.equals(targetWord)) return top.second;

            for (int i = 0; i < top.first.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] strArr = top.first.toCharArray();
                    strArr[i] = ch;
                    String newWord = new String(strArr);

                    if (hs.contains(newWord)) {
                        // startWord.toCharArray() will remove the startWord which we never changed, we just changed the char[]
                        q.add(new Pair(newWord, top.second + 1));
                    }
                }
            }
        }
        return 0;
    }
}
