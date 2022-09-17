package Recursion.Pattern;

public class Pattern1_2 {
    public static void main(String[] args) {
        pattern1(4 , 0);
        pattern2(4 , 0);
    }

    static void pattern1(int r , int c){
        if (r == 0){
            return;
        }

        if (c < r){
            System.out.print("*");
            pattern1(r, c+1);
        }
        else {
            System.out.println();
//            Here we need to change the value of c because c points to the same object , and these are reference variable which points to the same object. So to change the value of c , we reassigned it as 0 so the above value be 0 again.
            pattern1(r - 1, 0);
        }
    }

    static void pattern2(int r , int c){
        if (r == 0){
            return;
        }

//        Here the pattern will be printed in reverse order , ie , first all the recursive functions will be called and then while getting removed from the stack, it'll print the * and new line. The last list after (0,0) would be (1,1) , therefore we have an extra line .
        if (c < r){
            pattern2(r , c + 1);
            System.out.print("*");
        }
        else {
            pattern2(r - 1, 0);
//            Here we need to change the value of c because c points to the same object , and these are reference variable which points to the same object. So to change the value of c , we reassigned it as 0 so the above value be 0 again.
            System.out.println();
        }
    }
}
