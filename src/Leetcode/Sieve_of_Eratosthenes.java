package Leetcode;

import java.util.*;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(10));
    }
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        // code here
        boolean[] prime = new boolean[N+1];
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= N; i++){
            if (!prime[i]) {
                for (int j = i*i; j <= N; j+=i){
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i <= N; i++){
            if (!prime[i]) res.add(i);
        }

        return res;
    }
}
