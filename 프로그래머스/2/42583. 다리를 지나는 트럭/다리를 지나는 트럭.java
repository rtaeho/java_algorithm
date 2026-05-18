import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }

        int index = 0;
        while (index < truck_weights.length) {
            time++;
            sum -= q.poll();

            if (sum + truck_weights[index] <= weight) {
                q.offer(truck_weights[index]);
                sum += truck_weights[index];
                index++;
            } else {
                q.offer(0);
            }
        }

        return time + bridge_length;
    }
}