public class MinArrayElement {
    public static void main(String[] args) {
        int[] a = {11,22,33,44,88,99};

        int minElement = minEL(a);
        System.out.println(minElement);
    }

    static int minEL(int[] arr){
        int min = arr[0];
        for (int i = 1; i <= arr.length - 1; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
