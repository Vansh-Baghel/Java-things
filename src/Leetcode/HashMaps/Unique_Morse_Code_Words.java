//https://leetcode.com/problems/unique-morse-code-words/
package Leetcode.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Unique_Morse_Code_Words {
    public static void main(String[] args) {
        String[] arr = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(arr));
    }

    static int uniqueMorseRepresentations(String[] words) {

//        Solution using HashSet (Not optimized)

//        if (words.length <= 1) return words.length;
//
//        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//
////         sb to combine the string codes of each word .
//        StringBuffer sb = new StringBuffer();
//
////         To store the non repeating codes.
//        HashSet<String> hs = new HashSet<>();
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words[i].length(); j++) {
////                 Converting a b c to 0 1 2 format.
//                int indexOfChar = words[i].charAt(j) - 'a';
////                 Adding all the char into StringBuffer .
//                sb.append(codes[indexOfChar]);
//            }
////             Converting the string array into a single string and adding in hashset.
//            hs.add(sb.toString());
////             Clearing the stringbuffer to get other word's codes.
//            sb.delete(0 , sb.length());
//        }
////         All unique string will be added , therefore returning the size.
//        return hs.size();
//    }

//        Most optimized

//        if (words.length <= 1) return words.length;
//        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
//
////         sb to combine the string codes of each word .
//
////         To store the non repeating codes.
//        HashSet<String> hs = new HashSet<>();
//
//        for(String word : words){
//            StringBuilder transformation = new StringBuilder();
//            for (char c : word.toCharArray()){
//                transformation.append(codes[c - 'a']);
//            }
//            hs.add(transformation.toString());
//        }
////         All unique string will be added , therefore returning the size.
//        return hs.size();

//        Solution with less space complexity.
        HashSet<String> hm = new HashSet<>();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (int i = 0; i < words.length; i++) {
            String str = "";
            for (int j = 0; j < words[i].length(); j++) {

                str += codes[words[i].charAt(j) - 'a'];
            }
            hm.add(str);
        }
        return hm.size();
    }
}

