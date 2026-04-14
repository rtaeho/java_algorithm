import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int TEST_CASE = 0; TEST_CASE < T; TEST_CASE++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        adj[i].add(j);
                    }
                }
            }

            int minCC = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                minCC = Math.min(minCC, bfs(i, N, adj));
            }
            sb.append('#').append(TEST_CASE + 1).append(' ').append(minCC).append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int start, int N, ArrayList<Integer>[] adj) {
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int sum = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            sum += dist[curr];

            for (int next : adj[curr]) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.add(next);
                }
            }
        }
        return sum;
    }
}