public class BinarySearchSqrt {
    public static void main(String[] args) {
        int n = 40;
//        p is used to set the precision that till where we want the decimal to be solved correctly. Like very precise.
        int p = 3;
        double ans = sqrt(n , p);
        System.out.printf("%.3f" , ans);
    }

    static double sqrt(int n , int p){
        int s = 0 ;
//        Here the number itself is the length, as we are going from 0 to 40.
        int e = n;

//        This while condition is only for perfect squares.
        while (s < e){
            int m = s + (e - s)/2;
//            m will be same like arr[m] because the index number and the number at that index is the same.

            if (m * m > n){
                e = m - 1;
            }
            else if(m * m < n){
                s = m + 1;
            }
            else {
                return m;
            }
        }

        double incr = 0.1;
        double root = 0.0;

//        This condition is for the non-perfect square on n.
        for (int i = 0; i < p; i++) {
            while (root * root <= n){
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }

        return root;
    }


}

