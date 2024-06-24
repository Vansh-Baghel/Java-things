import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_steps_to_destination {
    public static void main(String[] args) {
        System.out.println(minSteps(2));
    }

    static int minSteps(int d) {
        Queue<int[]> q = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        q.add(new int[]{0,1});

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int[] top = q.poll();
                int pos = top[0], step = top[1];

                int left = pos - step, right = pos + step;
                if (left == d || right == d) return step;

                q.add(new int[]{left, step+1});
                q.add(new int[]{right, step+1});
            }
        }

        return -1;
    }
}
