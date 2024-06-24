package Leetcode.Contest;

import java.util.*;

public class Count_Beautiful_Substrings_II {
    public static void main(String[] args) {
        System.out.println(beautifulSubstrings("baeyh", 2));
    }

    // Mik bhai ka solution
    static long beautifulSubstrings(String s, int k) {
        long vowel = 0, cons = 0, result = 0;
        Map<Long, Map<Long, Long>> mp = new HashMap<>();
        mp.put(0L, new HashMap<>());
        mp.get(0L).put(0L, 1L);

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowel++;
            } else {
                cons++;
            }

            long pSum = vowel - cons;
            for (Map.Entry<Long, Long> entry : mp.getOrDefault(pSum, new HashMap<>()).entrySet()) {
                long pastVowelCount = entry.getKey();
                long count = entry.getValue();
                if ((vowel % k - pastVowelCount) * (vowel % k - pastVowelCount) % k == 0) //(a-b) * (a-b) % k -----> (a%k - b%k) * (a%k - b%k) %k
                    result += count;
            }

            mp.computeIfAbsent(vowel - cons, key -> new HashMap<>()).merge(vowel % k, 1L, Long::sum);
        }

        return result;
    }

    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    // TLE mine
    public long beautifulSubstrings2(String s, int k) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int n = s.length(), v = 0, c = 0, res = 0;
        hm.put(0, new ArrayList<>());
        hm.get(0).add(0);

        for (int i = 0; i < n; i++){
            if (isVowel(s.charAt(i))) {
                v++;
            } else c++;

            int dif = v - c;

            // Agar dif same aya, matlab dono k beech k number of v and c will be same.
            // dif will also be negative
            for (int prevVowCount: hm.getOrDefault(dif, new ArrayList<>())){
                int cur = v - prevVowCount;

                if ((cur * cur) % k == 0) res++;
            }

            hm.putIfAbsent(dif, new ArrayList<>());
            hm.get(dif).add(v);
        }

        return res;
    }

}
