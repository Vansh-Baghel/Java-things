package Recursion.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        mazePath("", 3 , 3);
        System.out.println(mazePathArray("" , 3 , 3));
    }
    
    static int count(int r, int c) {
//        If any of the element of row or column reaches 1 ie the last row or column then we know that theres only 1 path to reach the ans. So if any of the condition is true , then we increment the count.
        if (r == 1 || c == 1){
            return 1;
        }

//      This left refers to the flow chart. With respect to r and c , it refers to the row.
        int left = count (r - 1 , c);
//      This right refers to the flow chart. With respect to r and c , it refers to the col.
        int right = count (r , c - 1 );
//      Here if r = 1 , c = 2 , we return 1 , 2 .
        return left + right;
    }

    static void mazePath(String p, int r, int c) {
//      For any r or c , whenever we reach 1 then will definitely reach the target. So if both r and c are 1 , then we are at the element we asked for. Therefore print the path p.
        if (r == 1 && c == 1){
            System.out.println(p);
            return;
        }

//        D refers to Down because whenever the row is reduced it means that the element goes down.
       if (r > 1){
           mazePath(p + 'D' , r - 1 , c);
       }

//        R refers to Right because whenever the col is reduced it means that the element goes right.
        if (c > 1){
            mazePath(p + 'R' , r , c - 1);
        }
    }


    static ArrayList<String> mazePathArray(String p, int r, int c) {
        if (r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (r > 1){
            list.addAll(mazePathArray(p + 'D' , r - 1 , c));
        }

        if (c > 1){
            list.addAll(mazePathArray(p + 'R' , r , c - 1));
        }
        return list;
    }
}
