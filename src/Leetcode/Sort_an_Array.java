package Leetcode;

public class Sort_an_Array {
    public int[] sortArray(int[] nums) {
        divide(0, nums.length-1, nums);
        return nums;
    }

    static void divide(int low, int high, int[] nums){
        if (low == high) return;

        int mid = low + (high - low) / 2;

        divide(low, mid, nums);
        divide(mid + 1, high, nums);
        merge(low, mid, high, nums);
    }

    static void merge(int low, int mid, int high, int[] nums){
        int i = low, j = mid + 1, idx = 0;
        int[] temp = new int[(high - low) + 1];
        while (i <= mid && j <= high){
            if (nums[i] <= nums[j]) temp[idx++] = nums[i++];
            else temp[idx++] = nums[j++];
        }

        while (i <= mid) temp[idx++] = nums[i++];
        while (j <= high) temp[idx++] = nums[j++];

        for (int k = low; k <= high; k++){
            // i - low because temp is starting from 0, but arr can start from 3,4 anything
            nums[k] = temp[k - low];
        }
    }

    public int[] sortArray2(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    public void quickSort(int low, int high, int[] nums){
        if (low < high) {
            int pivot = findPivot(low, high, nums);
            quickSort(low, pivot - 1, nums);
            quickSort(pivot + 1, high, nums);
        }
    }

    public int findPivot(int low, int high, int[] nums){
        int i = low, j = high, pivot = nums[low];

        while (i < j){
            // We are finding a greater num than pivot. Smaller and equal in pivot comparison because we need to put the equal num somewhere.
            // i < high because we dont want it to exceed the higher limits
            while (nums[i] <= pivot && i < high) i++;
            while (nums[j] > pivot && j > low) j--;
            if (i < j) swap(i, j, nums);
        }

        swap(low, j, nums);
        return j;
    }

    public void swap (int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
