package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11400 {
    static LinkedList<Integer>[] graph;
    static int[] order;
    static int cnt;
    static ArrayList<int[]> bridges;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new LinkedList[V + 1];
        order = new int[V + 1];
        cnt = 0;
        bridges = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= V; i++) {
            if (order[i] == 0) {
                dfs(i, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bridges.size()).append("\n");
        bridges.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for (int[] bridge : bridges) {
            sb.append(bridge[0]).append(" ").append(bridge[1]).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int node, int parent) {
        order[node] = ++cnt;
        int low = order[node];

        for (int next : graph[node]) {
            if (next == parent) continue;
            if (order[next] == 0) {
                int childLow = dfs(next, node);
                if (childLow > order[node]) {
                    bridges.add(new int[]{Math.min(node, next), Math.max(node, next)});
                }
                low = Math.min(low, childLow);
            } else {
                low = Math.min(low, order[next]);
            }
        }
        return low;
    }
}
