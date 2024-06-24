package Leetcode.Contest;

public class Minimum_Moves_to_Capture_The_Queen {
    static int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // Means queen and rock on the same line
        if (a == e || b == f) {
            // There is an edge condition, that if the bishop is on the same line of before queen, if it is then rock cannot kill in 1 step.

            // aage side queen hai, uske peehhe bishop, uske peehhe rock
            if (a == e && a == c && ((d-b) * (d-f)) < 0) return 2;

            // Pechhe side queen hai, uske aage bishop, uske aage rock
            if (b == f && b == d && ((c-a) * (c-e)) < 0) return 2;

            // Warna easily in 1 step dead
            return 1;
        }

        // Queen and bishop on same diagonal. Dono ka difference same hua matlab same diag
        if (Math.abs(c - e) == Math.abs(d-f)){

            // Means agar same diagonal hua and rock is in between bishop and queen, toh 2 steps lagenge
            if (Math.abs(c - a) == Math.abs(d - b) && ((b - f) * (b - d) < 0)) return 2;
            return 1;
        }

        // Else maximum 2 steps lagenge
        return 2;
     }
}
