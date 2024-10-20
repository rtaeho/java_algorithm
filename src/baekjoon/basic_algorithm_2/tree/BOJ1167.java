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
package baekjoon.basic_algorithm_2.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//1167. 트리의 지름
public class BOJ1167 {
    static class Node {
        int to;   // 연결된 노드
        int cost; // 노드까지의 거리

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int V;               // 노드 수
    static List<Node> edges[]; // 트리의 간선 정보
    static boolean visit[];     // 방문 체크 배열
    static int candidate;       // 가장 먼 노드 후보
    static int max;             // 최대 거리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        edges = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        // 트리 초기화
        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<Node>();
        }

        // 간선 정보 입력
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break; // 종료 조건
                int cost = Integer.parseInt(st.nextToken());
                edges[vertex].add(new Node(next, cost)); // 간선 추가
            }
        }

        // 첫 번째 DFS로 임의의 노드에서 가장 먼 노드 찾기
        max = 0; // 최대 거리 초기화
        dfs(1, 0); // 1번 노드에서 시작

        // 두 번째 DFS로 가장 먼 노드에서 다시 가장 먼 노드 찾기
        visit = new boolean[V + 1]; // 방문 체크 배열 초기화
        max = 0; // 최대 거리 초기화
        dfs(candidate, 0); // 가장 먼 노드에서 시작

        // 트리의 지름 출력
        System.out.println(max);
    }

    // DFS를 통해 가장 먼 노드와 그 거리를 찾는 메서드
    static public void dfs(int v, int len) {
        if (len > max) {
            max = len; // 최대 거리 업데이트
            candidate = v; // 가장 먼 노드 업데이트
        }
        visit[v] = true; // 현재 노드 방문 처리

        // 연결된 노드 탐색
        for (int i = 0; i < edges[v].size(); i++) {
            Node next = edges[v].get(i);
            if (!visit[next.to]) {
                dfs(next.to, len + next.cost); // 다음 노드로 DFS 수행
            }
        }
    }
}
