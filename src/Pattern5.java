public class Pattern5 {
    public static void main(String[] args) {
        pattern5(5);
    }

    static void pattern5(int n){
        for (int rows = 1; rows <= 2 * n; rows++) {


            for (int columns = n - rows; columns <= 2 * n; columns++) {
                System.out.print(columns + " ");
            }
            System.out.println();
        }
    }
}
