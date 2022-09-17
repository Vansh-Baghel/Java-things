public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(2, 7));
        System.out.print(lcm(2 , 7));
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
//        Proof in the notes section.
        return a * b / gcd(a, b);
    }
}