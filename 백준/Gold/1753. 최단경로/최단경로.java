import java.io.*;
import java.util.*;

// 우선순위 큐에서 정렬 기준을 잡기 위해 Comparable을 구현합니다.
class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        // 가중치가 작은 것이 우선순위를 갖도록 오름차순 정렬합니다.
        return this.weight - o.weight;
    }
}

public class Main {
    static List<Node>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // 그래프 및 거리 배열 초기화
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF; // 초기 거리는 무한대로 설정
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 단방향 그래프이므로 u에서 v 방향만 추가
            graph[u].add(new Node(v, w));
        }

        // 다익스트라 실행
        dijkstra(K);

        // 결과 출력 (StringBuilder를 사용해야 시간 초과를 방지할 수 있습니다.)
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작점의 거리는 0으로 설정하고 큐에 삽입
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int now = curr.end;
            int weight = curr.weight;

            // 검증: 이미 더 짧은 경로로 처리된 적이 있다면 무시
            if (dist[now] < weight) {
                continue;
            }

            // 확장: 현재 노드와 연결된 인접 노드 확인
            for (Node next : graph[now]) {
                // 기존 거리보다 현재 노드를 거쳐가는 거리가 더 짧은 경우 (판단)
                if (dist[next.end] > dist[now] + next.weight) {
                    // 최단 거리 기록판 업데이트
                    dist[next.end] = dist[now] + next.weight;
                    // 갱신된 정보를 큐에 다시 넣음
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }
}