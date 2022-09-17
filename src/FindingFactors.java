import java.util.ArrayList;

public class FindingFactors {
    public static void main(String[] args) {
        int n = 36;
        factors(n);
        System.out.println();
        factorsInAscending(n);
    }

    static void factors(int n) {
        int c = 2;
        while (c * c <= n){
            if (n %  c == 0){
//                This condition is to avoid the repetition of certain number. Like if n = 36 then when c = 6 , also n / c = 6 . So it'll print 6 twice if this if condition was not written.
                if (n/c == c){
                    System.out.print(c);
                }
                else{
                    System.out.print(c + " " + n/c + " ");
                }
            }
            c++;
        }
    }

    static void factorsInAscending(int n) {
        int c = 2;
        ArrayList <Integer> list = new ArrayList<>();
        while (c * c <= n){
            if (n %  c == 0){
                if (n/c == c){
                    System.out.print(c + " ");
                }
                else{
                    System.out.print(c + " ");
                    list.add(n/c);
                }
            }
            c++;
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
