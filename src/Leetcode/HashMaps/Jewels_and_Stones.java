//https://leetcode.com/problems/jewels-and-stones/
package Leetcode.HashMaps;

import java.util.HashMap;

public class Jewels_and_Stones {
    static int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        HashMap<Character , Integer> jewelChar = new HashMap<>();
//        Inserting all the jewel chars in the set.
        for (int i = 0; i < jewels.length(); i++) {
            jewelChar.put(jewels.charAt(i) , i);
        }
//        Checking if the stones' char is present in the set, and if it does , increment the count.
        for (int j = 0; j < stones.length(); j++) {
            if (jewelChar.containsKey(stones.charAt(j))){
                count++;
            }
        }
        return count;
    }
}
