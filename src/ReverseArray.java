import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {11,22,33,44,88,99};
        int n = a.length - 1;
        for (int i = 0; i < n/2 ; i++) {
             int temp = a[i];
             a[i] = a[n-i];
            a[n-i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
