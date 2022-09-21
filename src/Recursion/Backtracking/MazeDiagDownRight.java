package Recursion.Backtracking;

import java.util.ArrayList;

public class MazeDiagDownRight {
    public static void main(String[] args) {
        System.out.println(mazePathArray("" , 3 , 3));
    }
    static ArrayList<String> mazePathArray(String p, int r, int c) {
//        Row and col numbering starts from 3 and goes on decreasing like 3,2,1  if there are 3 rows and cols . That's why when they reach 1 , it means they've found the ans.
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

//       D refers to the diagonal path.
        if (r > 1 && c > 1){
            list.addAll(mazePathArray(p + 'D' , r - 1 , c - 1));
        }

//       V refers to the vertical path.

        if (r > 1){
            list.addAll(mazePathArray(p + 'V' , r - 1 , c));
        }

//       H refers to the horizontal path.

        if (c > 1){
            list.addAll(mazePathArray(p + 'H' , r , c - 1));
        }
        return list;
    }
}
