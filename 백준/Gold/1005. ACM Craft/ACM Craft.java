import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1];
            int[] indegree = new int[N + 1];
            int[] totalTime = new int[N + 1];
            List<List<Integer>> adj = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
                adj.add(new ArrayList<>());
            }
            adj.add(new ArrayList<>()); // 인덱스 보정용

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                indegree[v]++;
            }

            int target = Integer.parseInt(br.readLine());

            // 위상 정렬을 위한 큐
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                totalTime[i] = buildTime[i];
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int next : adj.get(curr)) {
                    // 다음 건물의 완공 시간 = max(기존 시간, 현재 건물 완공 시간 + 다음 건물 소요 시간)
                    totalTime[next] = Math.max(totalTime[next], totalTime[curr] + buildTime[next]);
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            sb.append(totalTime[target]).append("\n");
        }
        System.out.print(sb);
    }
}