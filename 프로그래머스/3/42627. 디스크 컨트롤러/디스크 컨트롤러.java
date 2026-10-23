import java.util.*;

class Solution {

    static class Work {
        int id;
        int inqr;
        int spent;

        public Work(int id, int inqr, int spent) {
            this.id = id;
            this.inqr = inqr;
            this.spent = spent;
        }
    }

    public int solution(int[][] jobs) {
        // 요청 시각순
        PriorityQueue<Work> jobQ = new PriorityQueue<>((a, b) -> {
            if (a.inqr != b.inqr) {
                return Integer.compare(a.inqr, b.inqr);
            }
            return Integer.compare(a.id, b.id);
        });
        // 소요 시간 → 요청 시각 → 번호 순
        PriorityQueue<Work> waitQ = new PriorityQueue<>((a, b) -> {
            if (a.spent != b.spent) {
                return Integer.compare(a.spent, b.spent);
            }
            if (a.inqr != b.inqr) {
                return Integer.compare(a.inqr, b.inqr);
            }
            return Integer.compare(a.id, b.id);
        });

        for (int i = 0; i < jobs.length; i++) {
            jobQ.offer(new Work(i, jobs[i][0], jobs[i][1]));
        }

        int time = 0;
        int done = 0;
        int total = 0;

        while (done < jobs.length) {
            // 1. 지금 시각까지 도착한 작업을 대기 큐로 이동
            while (!jobQ.isEmpty() && jobQ.peek().inqr <= time) {
                waitQ.offer(jobQ.poll());
            }

            // 2. 대기 중인 작업이 없으면 다음 도착 시각으로 건너뛰기
            if (waitQ.isEmpty()) {
                time = jobQ.peek().inqr;
                continue;
            }

            // 3. 작업을 하나 꺼내서 끝까지 처리
            Work cur = waitQ.poll();
            time += cur.spent;
            total += time - cur.inqr;
            done++;
        }

        return total / jobs.length;
    }
}