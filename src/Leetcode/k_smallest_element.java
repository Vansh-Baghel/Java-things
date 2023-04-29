package Leetcode;

public class k_smallest_element {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    static int kthSmallest(int[][] matrix, int k) {
        // Brute force. Space complexity : O(n), Time complexity : O(N+k)
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // // Adding all nums in pq.
        // for(int i = 0 ; i < matrix.length ; i++){
        //     for (int j = 0 ; j < matrix[i].length ; j++){
        //             pq.add(matrix[i][j]);
        //     }
        // }

        // for (int i = 0; i < k - 1 ; i++){
        //     pq.poll();
        // }

        // return pq.peek();


        // Optimized approach: Space complexity : O(1), Time Complexity: O(N)
        int n = matrix.length;

        // Assigning to the first and last element of the matrix
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        while (start < end){
            int mid = start + (end - start) / 2;
            int count = 0;

            for (int i = 0 ; i < matrix.length ; i++){
                for (int j = 0; j < matrix[i].length; j++){
                    // Counting how many numbers are smaller and equal to the mid value.
                    if (matrix[i][j] <= mid){
                        count++;
                    } else {
                        break;
                    }
                }
            }

            // If the count is smaller means less numbers are smaller than mid, therefore increase the mid by start=mid+1.
            if(count < k){
                start = mid + 1;
            } else end = mid;
        }

        return start;
    }
}
