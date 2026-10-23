import java.util.*;

class Solution {
    List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }

        int answer = n;
        for (int[] w : wires) {
            int cnt = bfs(n, w[0], w[0], w[1]);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }

    int bfs(int n, int start, int cutA, int cutB) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if ((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) continue;
                if (visited[next]) continue;
                visited[next] = true;
                cnt++;
                q.offer(next);
            }
        }
        return cnt;
    }
}