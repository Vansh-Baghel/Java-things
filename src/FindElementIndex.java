public class FindElementIndex {
    public static void main(String[] args) {
        // To find the index of the element.
        int[] a = {11, 22, 33, 44, 88, 99};
        int target = 22;
        indexNumber(a, target);
    }
//        Creating direct for loop

/*        for (int i = 0; i < a.length - 1 ; i++) {
            if (a[i] == target){
                System.out.println(i);
        }
        }*/

//        Creating a function
        static int indexNumber(int[] arr , int t){
            if(arr.length == 0){
                return -1;
            }

    // Find the element using advaned for loop
        for (int element : arr) {
            if (element == t){
                System.out.println("The element is: - " + element);
            }
        }
            for (int i = 0; i < arr.length - 1 ; i++) {
                if (arr[i] == t){
                    System.out.println("Index of it" + " is " + i);
                }
            }
            return -1;
        }
    }


