package Recursion;

public class CountZeros {
    public static void main(String[] args) {
        int n = 300920;
        int count = 0;
        System.out.println(countingZeros(n , count));
    }
    static int countingZeros(int n, int c){
        if (n == 0){
            return c;
        }

        if (n % 10 == 0){
            countingZeros(n / 10 , c + 1);
        }

        return countingZeros(n / 10 , c);

    }
}
