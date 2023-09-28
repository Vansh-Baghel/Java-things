package Leetcode.Contest;

public class Weird_Island {
    static String solve(int A, int B) {
        if (A % 2 == 0 && B % 2 == 0) return "He";
        if (A % 2 == 1 && B % 2 == 1) return "She";
        else return "Punished";
    }
}
