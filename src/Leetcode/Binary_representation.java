package Leetcode;

public class Binary_representation {
    public static void main(String[] args) {
        System.out.println(getBinaryRep(2));
    }

    static String getBinaryRep(int N){
        // code here
        StringBuilder res = new StringBuilder();

        while (N != 0){
            res.append(N & 1);
            N >>= 1;
        }

        StringBuilder zeros = new StringBuilder();

        for(int i = 0; i < 30 - res.length(); i++){
            zeros.append(0+"");
        }

        return zeros + res.reverse().toString();
    }

    static String getBinaryRep2(int N){
        StringBuilder res = new StringBuilder(Integer.toBinaryString(N));

        StringBuilder zeros = new StringBuilder();

        for(int i = 0; i < 30 - res.length(); i++){
            zeros.append(0+"");
        }

        return zeros + res.toString();
    }
}
