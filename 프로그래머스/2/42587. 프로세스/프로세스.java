import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);
        int size = priorities.length;
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[1] == priorities[size - 1 - answer]) {
                answer++;
                
                if (current[0] == location) {
                    return answer;
                }
            } else {
                queue.add(current);
            }
        }

        return answer;
    }
}