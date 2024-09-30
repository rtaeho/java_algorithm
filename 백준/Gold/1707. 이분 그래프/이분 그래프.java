/*
문제
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.

그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다.

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

제한
2 ≤ K ≤ 5
1 ≤ V ≤ 20,000
1 ≤ E ≤ 200,000
예제 입력 1
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
예제 출력 1
YES
NO
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int K; // 테스트 케이스 개수
    static List<Integer>[] graph; // 인접 리스트
    static int[] color; // 정점 색 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점의 수
            int E = Integer.parseInt(st.nextToken()); // 간선의 수

            // 그래프 초기화
            graph = new ArrayList[V + 1]; // 1부터 V까지 사용하므로 V+1 크기로 생성
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 입력 처리
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v); // 양방향 간선 추가
                graph[v].add(u);
            }

            // 색 배열 초기화
            color = new int[V + 1]; // 0: 미방문, 1: 색1, -1: 색2

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) { // 아직 방문하지 않은 정점
                    isBipartite &= bfs(i); // BFS 탐색 및 이분 그래프 여부 확인
                }
            }

            // 결과 출력
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    // BFS 탐색 메소드
    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // 시작 정점에 색칠

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) { // 방문하지 않은 정점
                    // 현재 정점의 색과 반대 색으로 칠하기
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { // 같은 색이면 이분 그래프 아님
                    return false;
                }
            }
        }
        return true;
    }
}