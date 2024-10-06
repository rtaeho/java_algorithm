/*
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

예제 입력 1
6 5
1 2
2 5
5 1
3 4
4 6
예제 출력 1
2
예제 입력 2
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
예제 출력 2
1
 */
package baekjoon.basic_algorithm_2.graph_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N, M; // 정점의 개수, 간선의 개수
    static List<Integer>[] graph; // 인접 리스트
    static boolean[] visited; // 방문 체크 배열
    static int componentCount = 0; // 연결 요소 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList[N + 1]; // 1부터 N까지 사용하므로 N+1 크기로 생성
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); // 양방향 간선 추가
            graph[v].add(u);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화

        // 모든 정점을 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 정점이면
                dfs(i); // DFS 수행
                componentCount++; // 연결 요소 개수 증가
            }
        }

        // 결과 출력
        System.out.println(componentCount);
    }

    // DFS 메소드
    private static void dfs(int node) {
        visited[node] = true; // 현재 정점 방문 체크

        for (int neighbor : graph[node]) { // 현재 정점의 모든 이웃 정점 탐색
            if (!visited[neighbor]) { // 방문하지 않은 정점이면
                dfs(neighbor); // 재귀적으로 DFS 수행
            }
        }
    }
}
