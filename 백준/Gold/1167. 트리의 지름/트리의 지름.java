/*
문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.

예제 입력 1
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
예제 출력 1
11
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

//1167. 트리의 지름
public class Main {
    static class Node {
        int to;   // 연결된 노드
        int cost; // 노드까지의 거리

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int V;
    static ArrayList<Node> edges[];
    static boolean visit[];
    static int dist[];
    static int farthestNode; // 가장 먼 노드
    static int maxDistance;   // 최대 거리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        edges = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break; // 종료 조건
                int cost = Integer.parseInt(st.nextToken());
                edges[vertex].add(new Node(next, cost));
            }
        }

        // 첫 번째 BFS로 임의의 노드에서 가장 먼 노드 찾기
        bfs(1);
        // 두 번째 BFS로 가장 먼 노드에서 다시 가장 먼 노드 찾기
        bfs(farthestNode);

        // 트리의 지름 출력
        System.out.println(maxDistance);
    }

    static void bfs(int start) {
        Queue<Node> queue = new ArrayDeque<Node>();
        dist = new int[V + 1]; // 거리 배열 초기화
        visit = new boolean[V + 1]; // 방문 체크 배열 초기화
        queue.add(new Node(start, 0));
        visit[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node neighbor : edges[cur.to]) {
                if (!visit[neighbor.to]) {
                    visit[neighbor.to] = true;
                    dist[neighbor.to] = dist[cur.to] + neighbor.cost;
                    queue.add(new Node(neighbor.to, neighbor.cost));
                }
            }
        }

        // BFS 한번 끝날 때마다 가장 긴 거리 값을 업데이트
        for (int i = 1; i <= V; i++) {
            if (dist[i] > maxDistance) {
                maxDistance = dist[i]; // 최대 거리 업데이트
                farthestNode = i;      // 가장 먼 노드 업데이트
            }
        }
    }
}
