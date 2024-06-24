package Leetcode;

import java.util.*;

public class Path_Crossing {
    static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> hs = new HashSet<>();

        hs.add("0_0");

        for (char ch: path.toCharArray()){
            if (ch == 'N') y++;
            if (ch == 'S') y--;
            if (ch == 'W') x--;
            if (ch == 'E') x++;

            if (hs.contains(x + "_" + y)) return true;
            hs.add(x + "_" + y);
        }

        return false;
    }
}
