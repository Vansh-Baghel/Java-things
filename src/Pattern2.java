public class Pattern2 {
    public static void main(String[] args) {
        pattern1(4);
    }

    static void pattern1(int n){
        for (int rows = 0; rows < n; rows++) {
            for (int columns = 0; columns < n - rows; columns++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
