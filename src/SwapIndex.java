import java.util.Arrays;

public class SwapIndex {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        swap(a , 1 , (a.length - 2));

        System.out.println(Arrays.toString(a));
    }

    static void swap(int[] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2]=  temp;
    }
}
