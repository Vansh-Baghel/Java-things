//https://leetcode.com/problems/excel-sheet-column-number/
package Leetcode;

public class Excel_Sheet_ColumnNumber {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int p = 0;
        for (int i = columnTitle.length() - 1; i >= 0 ; i--) {
            // From A-Z there are 26 chars, From AA-AZ there are 26 and so on. There is a gap of 26 alphabets in seq depending on the number of chars in one string . The power of 26 increases like bitwise operator and if we add all of them, then will get the answer.
            // Example: AB will give 1 * 26^0 + 0 * 26^1 of B and A respectively.
            sum += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, p++);
        }
        return sum;
    }
}
