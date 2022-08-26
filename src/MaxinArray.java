public class MaxinArray {
    public static void main(String[] args) {
        int[] a = {11,22,33,44,88};
        System.out.println(max(a));
    }

    static int max(int[] arr){
        int maxVal = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}
