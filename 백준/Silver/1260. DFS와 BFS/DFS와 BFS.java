/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1
1 2 4 3
1 2 3 4
예제 입력 2
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2
3 1 2 5 4
3 1 4 2 5
예제 입력 3
1000 1 1000
999 1000
예제 출력 3
1000 999
1000 999
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int N, M, V; // 정점의 수, 간선의 수, 시작 정점
    static List<Integer>[] graph; // 인접 리스트로 그래프 표현
    static boolean[] visitedDFS; // DFS 방문 체크
    static boolean[] visitedBFS; // BFS 방문 체크
    static StringBuilder dfsResult = new StringBuilder(); // DFS 결과 저장
    static StringBuilder bfsResult = new StringBuilder(); // BFS 결과 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 N, M, V를 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1]; // 1번부터 N번까지 사용하므로 N+1 크기로 생성
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b); // 양방향 간선
            graph[b].add(a);
        }

        // 인접 리스트를 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 탐색 수행
        visitedDFS = new boolean[N + 1]; // DFS 방문 배열 초기화
        dfs(V); // 시작 정점 V로 DFS 탐색

        // BFS 탐색 수행
        visitedBFS = new boolean[N + 1]; // BFS 방문 배열 초기화
        bfs(V); // 시작 정점 V로 BFS 탐색

        // 결과 출력
        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    // DFS 탐색 메소드
    private static void dfs(int node) {
        visitedDFS[node] = true; // 현재 정점 방문 체크
        dfsResult.append(node).append(" "); // 결과에 현재 정점 추가

        for (int next : graph[node]) {
            if (!visitedDFS[next]) { // 방문하지 않은 정점만 탐색
                dfs(next);
            }
        }
    }

    // BFS 탐색 메소드
    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작 정점을 큐에 추가
        visitedBFS[start] = true; // 시작 정점 방문 체크

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 정점 꺼내기
            bfsResult.append(node).append(" "); // 결과에 현재 정점 추가

            for (int next : graph[node]) {
                if (!visitedBFS[next]) { // 방문하지 않은 정점만 큐에 추가
                    visitedBFS[next] = true; // 방문 체크
                    queue.add(next);
                }
            }
        }
    }
}