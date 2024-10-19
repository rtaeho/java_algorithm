/*
문제
루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.

출력
첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.

예제 입력 1
7
1 6
6 3
3 5
4 1
2 4
4 7
예제 출력 1
4
6
1
3
1
4
예제 입력 2
12
1 2
1 3
2 4
3 5
3 6
4 7
4 8
5 9
5 10
6 11
6 12
예제 출력 2
1
1
2
3
3
4
4
5
5
6
6
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N; // 노드의 개수
    static List<List<Integer>> tree = new ArrayList<>(); // 트리의 인접 리스트
    static int[] parent; // 각 노드의 부모 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u); // 양방향 간선 추가
        }

        parent = new int[N + 1]; // 부모 노드 배열 초기화
        Arrays.fill(parent, -1); // 부모 노드 배열을 -1로 초기화

        bfs(1); // 루트 노드 1에서 BFS 수행

        // 2번 노드부터 N번 노드까지 부모 노드 출력
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    // BFS를 사용하여 부모 노드 찾기
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parent[start] = 0; // 루트 노드의 부모는 0 (없음)

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : tree.get(current)) {
                if (parent[neighbor] == -1) { // 아직 방문하지 않은 노드
                    parent[neighbor] = current; // 부모 노드 설정
                    queue.offer(neighbor); // 큐에 추가
                }
            }
        }
    }
}