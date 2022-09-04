public class Pattern3 {
    public static void main(String[] args) {
    pattern3(4);
}

    static void pattern3(int n){
        for (int rows = 0; rows < 2 * n; rows++) {
            int totalColumns = rows > n ? (n - (rows - n)) : rows;
            for (int columns = 0; columns < totalColumns; columns++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
