package Leetcode;

public class Column_name_from_a_given_column_number {
    public static void main(String[] args) {
        System.out.println(colName(80));
    }

    static String colName (long n){
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            n--;
            long rem = n % 26;
            ans.append((char)('A' + rem));
            n /= 26;
        }

        ans.reverse();
        return ans.toString();
    }
}
