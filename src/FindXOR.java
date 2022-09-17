public class FindXOR {
    public static void main(String[] args) {
        int a = 6;
        int ans = findingXOR(a);
        System.out.println(ans);

//      Finding XOR for given range.
        int b = 3;
        int c = 9;
//      If we XOR the last number with the numbers before the start number then those numbers will be excluded.
        int rangeAns = findingXOR(c) ^ findingXOR(b - 1);
        System.out.print(rangeAns);
    }

    static int findingXOR(int a) {
        if (a%4==0){
            return a;
        }
        if (a%4==1){
            return 1;
        }
        if (a%4==2){
            return a+1;
        }
            return 0;
    }
}
