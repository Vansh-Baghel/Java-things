package Leetcode;
import java.util.*;

public class Word_Ladder_II{
    public static void main(String[] args) {

    String[] wordArray = {"des","der","dfr","dgt","dfs"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
        List<List<String>> ans = findLadders("der", "dfs", wordList);
        System.out.println(ans);
    }

    static class Pair{
        String first;
        int level;
        public Pair(String first, int level){
            this.first = first;
            this.level = level;
        }
    }

    // For GFG
    static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList){
        HashSet<String> hs = new HashSet<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        int level = 0;
        ArrayList <String> strToRemove = new ArrayList < > ();

        strToRemove.add(startWord);
        list.add(startWord);
        q.add(list);

        hs.addAll(Arrays.asList(wordList));

        while (!q.isEmpty()){

            ArrayList<String> top = q.poll();
            // Changing the last string.
            String endWord = top.get(top.size() - 1);

            if (top.size() > level) {
                level++;
                for (String it: strToRemove) {
                    hs.remove(it);
                }
            }

            if (endWord.equals(targetWord)){
                // ans list will have same size, therefore if ans ka first list milgya, then for further lists we will only add lists with size same as that of first.
                if (ans.isEmpty() || ans.get(0).size() == top.size()){
                    ans.add(top);
                }
            }

            for (int j = 0; j < endWord.length(); j++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = endWord.toCharArray();
                    charArray[j] = ch;
                    String newWord = new String(charArray);

                    if (hs.contains(newWord)){
                        top.add(newWord);
                        strToRemove.add(newWord);
                        ArrayList<String> newList = new ArrayList<>(top);
                        q.add(newList);
                        top.remove(top.size() - 1);
                    }
                }
            }
        }

        return ans;
    }

    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static List<List<String>> ans = new ArrayList<>();

    // For Leetcode, more optimized solution. Starting from backwards and skipping the unnecessary steps.
    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<String>();
        Queue<String> q = new LinkedList<>();

        hs.addAll(wordList);

        q.add(beginWord);
        hm.put(beginWord, 1);
        hs.remove(beginWord);

        while (!q.isEmpty()){
            String top = q.poll();
            int steps = hm.get(top);

            if (top.equals(endWord)) break;

            for (int i = 0; i < top.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] strArr = top.toCharArray();
                    strArr[i] = ch;
                    String newWord = new String(strArr);

                    if (hs.contains(newWord)) {
                        hm.put(newWord, steps+1);
                        q.add(newWord);
                        hs.remove(newWord);
                    }
                }
            }
        }

        ans= new ArrayList<>();

        if (hm.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq, beginWord);
        }

        return ans;
    }

    static void dfs(String word, List<String> seq, String beginWord) {
        if (word.equals(beginWord)){
            List<String> list = new ArrayList <>(seq);
            Collections.reverse(list);
            ans.add(list);
            return;
        }

        int size = word.length();
        int steps = hm.get(word);

        for (int i = 0; i < size; i++) {
            for(char ch = 'a' ; ch <= 'z'; ch++){
                char[] charArray = word.toCharArray();
                charArray[i] = ch;
                String newWord = new String(charArray);

                if (hm.containsKey(newWord) && hm.get(newWord) + 1 == steps){
                    seq.add(newWord);
                    dfs(newWord, seq, beginWord);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}
