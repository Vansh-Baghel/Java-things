public class FiboUsingFormula {
    public static void main(String[] args) {
        int ans = fibo(3);
        System.out.println(ans);
    }

    static int fibo(int n){
        // Put the brackets carefully.
        return (int) ((Math.pow(((1+Math.sqrt(5))/2),n)-Math.pow(((1-Math.sqrt(5))/2),n))/Math.sqrt(5));
    }

}
