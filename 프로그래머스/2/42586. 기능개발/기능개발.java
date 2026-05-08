import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain + speeds[i] - 1) / speeds[i];
            q.add(day);
        }

        List<Integer> list = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int now = q.poll();
            int cnt = 1;

            while (!q.isEmpty() && q.peek() <= now) {
                q.poll();
                cnt++;
            }
            list.add(cnt);
        }

        return list.stream().mapToInt(s->s).toArray();
    }
}