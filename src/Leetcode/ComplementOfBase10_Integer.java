package Leetcode;

public class ComplementOfBase10_Integer {
    public static void main(String[] args) {

    }

    static int bitwiseComplement(int n) {
//        If didn't understand still then go to https://www.youtube.com/watch?v=0fwrMYPcGQ0
//        This condition is created because if the n is 0 , then it'll simply return 0 because ~n & mask will give 1 & 0 which is 0.
        if (n == 0) {
            return 1;
        }

//        Storing the original value n in m.
        int m = n;
        int mask = 0;

//        This while loop is created just to find the mask. We want such a value which creates all 1 till the bit of n doesnt equal to 0 while right shifting . EG: - 00...010101 (32 Bits means 32 numbers will be there in it) and we want 00..0011111 . Why do we need this ? Because while complementing the n (~n) all the 0 will be converted to 1 and vice versa . Therefore if n is 00..0010101 then its complement will be 11..1101010 . We dont want rest of the 1 which is present before the numbers instead of zeros .
        while (m!=0){
            mask = (mask << 1) | 1;
            m = m >> 1 ;
        }

//        Complementing n and using & operator with mask will give required value . EG: - n = 00..00101 , ~n = 11..11010 , mask = 00..00111 . Therefore it will return 00..00010 which we needed. Before it was 11.11010 which we didnt want.
        int ans = ~n  & mask;
        return ans;
    }
}
