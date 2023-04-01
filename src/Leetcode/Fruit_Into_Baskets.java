//https://leetcode.com/problems/fruit-into-baskets/
package Leetcode;

public class Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
//        -1 because we couldn't predict the number at index 1. If first and second nums are same then its not correct to set secondlast and last as 0 and 1.
        int lastfruit = -1;
        int sec_lastfruit = -1;
        int lastcount = 0;
        int curMax = 0;
        int max = 0;

        for (int fruit : fruits) {
//            Checking if the fruit is same as the 2 nums or not. If not then there might be possibility that the last num is same in new combination. Therefore adding the last count as well.
            if (fruit == lastfruit || fruit == sec_lastfruit){
                curMax += 1;
            }
            else{
                curMax = lastcount + 1;
            }

//            Incrementing the last count if the num is same, else resetting to 1.
            if (fruit == lastfruit){
                lastcount += 1;
            }else{
                lastcount = 1;
            }

//          if not same then change the sec last as current last and last as the current fruit.
            if (fruit != lastfruit){
                sec_lastfruit = lastfruit;
                lastfruit = fruit;
            }

            max= Math.max(max, curMax);
        }
        return max;
    }
}
