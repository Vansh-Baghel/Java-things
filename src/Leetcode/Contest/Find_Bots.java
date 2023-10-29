package Leetcode.Contest;

import java.util.HashSet;

public class Find_Bots {
    public static void main(String[] args) {

    }

    public int[] findBots(String usernames[], int n){
        HashSet<Character> hs = new HashSet<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < usernames[i].length(); j+=2) {
                hs.add(usernames[i].charAt(j));
            }
            ans[i] = isPrime(hs.size()) ? 1 : 0;
            hs.clear();

        }
        return ans;
    }

    private boolean isPrime(int num) {
        return num % 2 != 0 && num % 3 != 0 && num % 5 != 0 && num % 7 != 0;
    }
}
