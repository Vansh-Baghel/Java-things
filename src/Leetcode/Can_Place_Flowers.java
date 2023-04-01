//https://leetcode.com/problems/can-place-flowers/
package Leetcode;

public class Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 ) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+ 1 ] == 0 )){
                flowerbed[i] = 1;
                n --;
                if (n == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
