/*
문제
BOJ에서 정답이 여러가지인 경우에는 스페셜 저지를 사용한다. 스페셜 저지는 유저가 출력한 답을 검증하는 코드를 통해서 정답 유무를 결정하는 방식이다. 오늘은 스페셜 저지 코드를 하나 만들어보려고 한다.

정점의 개수가 N이고, 정점에 1부터 N까지 번호가 매겨져있는 양방향 그래프가 있을 때, BFS 알고리즘은 다음과 같은 형태로 이루어져 있다.

큐에 시작 정점을 넣는다. 이 문제에서 시작 정점은 1이다. 1을 방문했다고 처리한다.
큐가 비어 있지 않은 동안 다음을 반복한다.
큐에 들어있는 첫 정점을 큐에서 꺼낸다. 이 정점을 x라고 하자.
x와 연결되어 있으면, 아직 방문하지 않은 정점 y를 모두 큐에 넣는다. 모든 y를 방문했다고 처리한다.
2-2 단계에서 방문하지 않은 정점을 방문하는 순서는 중요하지 않다. 따라서, BFS의 결과는 여러가지가 나올 수 있다.

트리가 주어졌을 때, 올바른 BFS 방문 순서인지 구해보자.

입력
첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다. 마지막 줄에는 BFS 방문 순서가 주어진다. BFS 방문 순서는 항상 N개의 정수로 이루어져 있으며, 1부터 N까지 자연수가 한 번씩 등장한다.

출력
입력으로 주어진 BFS 방문 순서가 올바른 순서면 1, 아니면 0을 출력한다.

예제 입력 1
4
1 2
1 3
2 4
1 2 3 4
예제 출력 1
1
올바른 순서는 1, 2, 3, 4와  1, 3, 2, 4가 있다.

예제 입력 2
4
1 2/*
문제
BOJ에서 정답이 여러가지인 경우에는 스페셜 저지를 사용한다. 스페셜 저지는 유저가 출력한 답을 검증하는 코드를 통해서 정답 유무를 결정하는 방식이다. 오늘은 스페셜 저지 코드를 하나 만들어보려고 한다.

정점의 개수가 N이고, 정점에 1부터 N까지 번호가 매겨져있는 양방향 그래프가 있을 때, BFS 알고리즘은 다음과 같은 형태로 이루어져 있다.

큐에 시작 정점을 넣는다. 이 문제에서 시작 정점은 1이다. 1을 방문했다고 처리한다.
큐가 비어 있지 않은 동안 다음을 반복한다.
큐에 들어있는 첫 정점을 큐에서 꺼낸다. 이 정점을 x라고 하자.
x와 연결되어 있으면, 아직 방문하지 않은 정점 y를 모두 큐에 넣는다. 모든 y를 방문했다고 처리한다.
2-2 단계에서 방문하지 않은 정점을 방문하는 순서는 중요하지 않다. 따라서, BFS의 결과는 여러가지가 나올 수 있다.

트리가 주어졌을 때, 올바른 BFS 방문 순서인지 구해보자.

입력
첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다. 마지막 줄에는 BFS 방문 순서가 주어진다. BFS 방문 순서는 항상 N개의 정수로 이루어져 있으며, 1부터 N까지 자연수가 한 번씩 등장한다.

출력
입력으로 주어진 BFS 방문 순서가 올바른 순서면 1, 아니면 0을 출력한다.

예제 입력 1
4
1 2
1 3
2 4
1 2 3 4
예제 출력 1
1
올바른 순서는 1, 2, 3, 4와  1, 3, 2, 4가 있다.

예제 입력 2
4
1 2
1 3
2 4
1 2 4 3
예제 출력 2
0
 */
package baekjoon.basic_algorithm_2.graph_1_challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ16940 {
    static List<Integer>[] graph; // 그래프 표현 (인접 리스트)
    static int N; // 정점의 수
    static int[] bfsOrder; // BFS 방문 순서
    static boolean[] visited; // 방문 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1]; // 1부터 N까지 사용하므로 N+1 크기로 생성
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // 각 정점의 인접 리스트 초기화
        }

        // 그래프 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 양방향 간선 추가
        }

        bfsOrder = new int[N]; // BFS 방문 순서 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bfsOrder[i] = Integer.parseInt(st.nextToken());
        }

        // BFS 방문 순서가 올바른지 체크
        if (isValidBFSOrder(1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // BFS 방문 순서 체크
    private static boolean isValidBFSOrder(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1]; // 방문 체크 배열 초기화
        queue.offer(start);
        visited[start] = true;

        int index = 0; // bfsOrder 인덱스
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 정점이 BFS 순서에서 다음 정점과 일치하지 않으면 잘못된 순서
            if (current != bfsOrder[index++]) {
                return false;
            }

            // 연결된 정점들을 확인
            List<Integer> neighbors = graph[current];
            List<Integer> unvisitedNeighbors = new ArrayList<>();

            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    unvisitedNeighbors.add(neighbor);
                }
            }

            // 아직 방문하지 않은 인접 정점들을 큐에 추가
            for (int i = 0; i < unvisitedNeighbors.size(); i++) {
                queue.offer(unvisitedNeighbors.get(i));
                visited[unvisitedNeighbors.get(i)] = true; // 방문 처리
            }
        }

        return true; // 모든 정점을 올바른 순서로 방문한 경우
    }
}
1 3
2 4
1 2 4 3
예제 출력 2
0
 */
package baekjoon.basic_algorithm_2.graph_1_challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ16940 {
    static List<Integer>[] graph; // 그래프 표현 (인접 리스트)
    static int N; // 정점의 수
    static int[] bfsOrder; // BFS 방문 순서
    static boolean[] visited; // 방문 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1]; // 1부터 N까지 사용하므로 N+1 크기로 생성
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // 각 정점의 인접 리스트 초기화
        }

        // 그래프 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u); // 양방향 간선 추가
        }

        bfsOrder = new int[N]; // BFS 방문 순서 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bfsOrder[i] = Integer.parseInt(st.nextToken());
        }

        // BFS 방문 순서가 올바른지 체크
        if (isValidBFSOrder(1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // BFS 방문 순서 체크
    private static boolean isValidBFSOrder(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1]; // 방문 체크 배열 초기화
        queue.offer(start);
        visited[start] = true;

        int index = 0; // bfsOrder 인덱스
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 정점이 BFS 순서에서 다음 정점과 일치하지 않으면 잘못된 순서
            if (current != bfsOrder[index++]) {
                return false;
            }

            // 연결된 정점들을 확인
            List<Integer> neighbors = graph[current];
            List<Integer> unvisitedNeighbors = new ArrayList<>();

            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    unvisitedNeighbors.add(neighbor);
                }
            }

            // 아직 방문하지 않은 인접 정점들을 큐에 추가
            for (int i = 0; i < unvisitedNeighbors.size(); i++) {
                queue.offer(unvisitedNeighbors.get(i));
                visited[unvisitedNeighbors.get(i)] = true; // 방문 처리
            }
        }

        return true; // 모든 정점을 올바른 순서로 방문한 경우
    }
}