public class ElementInRange {
    public static void main(String[] args) {
        int[] a = {11,22,33,44,88,99};
        int el = 33;
        int index = linearSearch(a , el , 1 , 4);
        System.out.println(index);
    }

    static int linearSearch(int[] arr , int el , int start , int end){
        for (int i = start; i <= end; i++) {
            if (el == arr[i]){
              return i;
            }
        }
        return -1;
    }
}
