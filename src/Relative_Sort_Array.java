import java.util.*;

public class Relative_Sort_Array {
    public static void main(String[] args) {
        int[] a1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, a2 = {2,42,38,0,43,21};
        System.out.println(Arrays.toString(relativeSortArray(a1, a2)));
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr1.length, m = arr2.length;

        for (int i = 0; i < n; i++){
            hm.put(arr1[i], hm.getOrDefault(arr1[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int j : arr2) {
            int cnt = hm.remove(j);
            while (cnt-- > 0) {
                result.add(j);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        int i2 = 0;

        for (int num : hm.keySet()) {
            for (int i = 0; i < hm.get(num); i++) {
                sorted.add(num);
            }
        }

        Collections.sort(sorted);
        result.addAll(sorted);

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
