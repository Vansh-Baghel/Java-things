public class FlippingImage {
    public static void main(String[] args) {

    }

    static int[][] flipAndInvertImage(int[][] image){
        for (int[] row : image){
            for (int i = 0 ; i < (image[0].length + 1) / 2 ; i++){
                int temp = row[i] ^ 1;
                row[i] = row[image[i].length - 1 - i] ^ 1;
                row[image[i].length - 1 - i] = temp;
            }
        }
        return image;
    }
}
