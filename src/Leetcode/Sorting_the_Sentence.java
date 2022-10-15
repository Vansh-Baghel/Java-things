//https://leetcode.com/problems/sorting-the-sentence/
package Leetcode;

public class Sorting_the_Sentence {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }

    static String sortSentence(String s) {
        String[] stringArr = s.split(" ");
        String[] tempArr = new String[stringArr.length];
        String combineArr = "";


        for (String item : stringArr) {
//            This will get us the ascii value of the number present in the last index of any number . So subtracting it will 0 will give us the value between 0 to 9.
            int lastNumber = item.charAt(item.length() - 1) - '0';
//            lastNumber - 1 because the numbers are starting from 1 and the index starts from 0. Substring ka last count is not counted therefore if we do length - 1 then it will only go to the second last digit as we dont want the number included.
            tempArr[lastNumber - 1] = item.substring(0, item.length() - 1);
        }
        for (String value : tempArr) {
//            This will combine the array as a string.
            combineArr += value + " ";
        }
//        This will remove the extra space which will be formed in the last .
        return combineArr.trim();
    }
}
