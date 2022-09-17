public class PrimeNumberConcepts {
    public static void main(String[] args) {
        int n = 40;
        boolean ans = isPrime(n);

//      This boolean is used to print the end number too in the prime list, otherwise the n = 40 will just be 39.
        boolean[] primes = new boolean[n + 1];
        System.out.println(ans);
        primeForRange(n, primes);
    }
    static boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        int c = 2;
//      Here the logic is that theres no meaning to check all the numbers above the sqrt because the multiple just keeps on repeating. c * c <= n or c <= n are same.
        while (c * c <= (n)) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    static void primeForRange(int n , boolean[] primes){
//      If primes is false , then its a prime. Else its not a prime. This is used to eliminate all the numbers which are divisible by prime number .
        for (int i = 2; i <= n; i++) {
            if (!primes[i]){
//                i * 2 to not check the i which is already been checked. j+=i to keep on going to the next number which is divisible. Like 3,3+3,3+3+3....
                for (int j = i * 2; j <= n; j+=i) {
//                  Mark them true so that they dont get included.
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}