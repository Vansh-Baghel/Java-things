public class Tower_Of_Hanoi {
    public static void main(String[] args) {
        towers(3 , 'A' , 'C' , 'B');
    }

    static void towers(int n , char A , char B , char C){
        if (n == 1){
            System.out.println("Moved 1 from " + A + " to " + B);
            return;
        }

        towers(n - 1, A , C , B);
        System.out.println("Moved " + n + " from " + A + " to " + B);
        towers(n - 1, C , B , A);
    }
}