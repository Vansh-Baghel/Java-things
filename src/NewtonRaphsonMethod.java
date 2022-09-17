public class NewtonRaphsonMethod {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(sqrt(n));
    }

    static double sqrt(int n){
        double x = n;

        double root;
//        Infinite loop condition.
        while (true){
            root = 0.5 * (x + n/x);

//          Math.abs is used because difference can also be negative but will just see the positive difference. 1 here describes that how precise we want like if the difference reaches 1 then we are stopping the while loop.
            if (Math.abs(root - x) < 1){
                break;
            }
            x = root;
        }
        return root;
    }
}
