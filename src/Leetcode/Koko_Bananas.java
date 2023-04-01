//https://leetcode.com/problems/koko-eating-bananas/
package Leetcode;

public class Koko_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
      int s = 1;
      int e = Integer.MAX_VALUE;

        while (s < e){
          int m = s + (e - s) /2;
          if (totalHrs(piles , m , h)) e = m - 1;
          else s = m + 1;
      }
        return s;
    }

    public boolean totalHrs(int[] piles, int k , int  h){
        int totalHours = 0;

        for(int pile : piles){
            totalHours += pile / k;
            if (pile % k != 0) totalHours++;
        }
        return totalHours < h;
    }
}
