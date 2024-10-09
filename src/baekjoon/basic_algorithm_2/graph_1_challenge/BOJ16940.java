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
1 2
1 3
2 4
1 2 4 3
예제 출력 2
0
 */
package baekjoon.basic_algorithm_2.graph_1_challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16940 {
    static int n; // 정점의 수
    static int index; // BFS 순서 인덱스
    static List<HashSet<Integer>> list; // 인접 리스트
    static int[] visit; // 방문 여부
    static int[] answer; // 정답 순서
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visit = new int[n + 1];
        answer = new int[n + 1];
        queue = new LinkedList<>();

        // 인덱스 값을 1 부터 씀
        for (int i = 0; i <= n; i++) {
            list.add(new HashSet<>());
        }

        // 인접 리스트 생성
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u); // 양방향 간선 추가
        }

        // 정답 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        // 시작이 1이 아니면 X
        if (answer[1] != 1) {
            System.out.println("0");
            return;
        }

        bfsCheck(1);
    }

    public static void bfsCheck(int x) {
        queue.offer(x);
        visit[x] = 1;
        index = 2; // 2 번째부터 탐색

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 노드의 자식들 방문 처리
            int count = 0;
            for (int next : list.get(cur)) {
                if (visit[next] == 0) {
                    visit[next] = 1;
                    count++;
                }
            }

            for (int i = index; i < index + count; i++) {
                // 정답이 현재 노드의 자식이 아니라면 X
                if (i >= answer.length || visit[answer[i]] == 0) {
                    System.out.println("0");
                    return;
                }
                // 정답이 현재 노드의 자식이면 큐에 순서대로 삽입
                else {
                    queue.offer(answer[i]);
                }
            }
            index += count;
        }

        System.out.println("1");
    }
}