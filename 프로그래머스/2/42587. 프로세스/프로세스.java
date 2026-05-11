import java.util.*;

class Job {
    int number;
    int priority;
    public Job(int number, int priority) {
        this.number = number;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Job> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Job(i, priorities[i]));
            pq.offer(priorities[i]);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Job current = q.poll();
            if (current.priority == pq.peek()) {
                cnt++;
                pq.poll();
                if (current.number == location) {
                    return cnt;
                }
            } else {
                q.add(current);
            }
        }
        return cnt;
    }
}