public class Pattern4 {
    public static void main(String[] args) {
        pattern4(5);
    }

    static void pattern4(int n){
        for (int rows = 0; rows < 2 * n; rows++) {
            int totalColumns = rows > n ? (n - (rows - n)) : rows;
            int noOfSpaces = n - totalColumns;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }
            for (int columns = 0; columns < totalColumns; columns++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
