/*
문제
BOJ에서 정답이 여러가지인 경우에는 스페셜 저지를 사용한다. 스페셜 저지는 유저가 출력한 답을 검증하는 코드를 통해서 정답 유무를 결정하는 방식이다. 오늘은 스페셜 저지 코드를 하나 만들어보려고 한다.

정점의 개수가 N이고, 정점에 1부터 N까지 번호가 매겨져있는 양방향 그래프가 있을 때, DFS 알고리즘은 다음과 같은 형태로 이루어져 있다.

1
2
3
4
5
6
7
8
9
10
11
12
void dfs(int x) {
    if (check[x] == true) {
        return;
    }
    check[x] = true;
    // x를 방문
    for (int y : x와 인접한 정점) {
        if (check[y] == false) {
            dfs(y);
        }
    }
}
이 문제에서 시작 정점은 1이기 때문에 가장 처음에 호출하는 함수는 dfs(1)이다. DFS 방문 순서는 dfs함수에서 // x를 방문 이라고 적힌 곳에 도착한 정점 번호를 순서대로 나열한 것이다.

트리가 주어졌을 때, 올바른 DFS 방문 순서인지 구해보자.

입력
첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다. 마지막 줄에는 DFS 방문 순서가 주어진다. DFS 방문 순서는 항상 N개의 정수로 이루어져 있으며, 1부터 N까지 자연수가 한 번씩 등장한다.

출력
입력으로 주어진 DFS 방문 순서가 올바른 순서면 1, 아니면 0을 출력한다.

예제 입력 1
4
1 2
1 3
2 4
1 2 3 4
예제 출력 1
0
예제 입력 2
4
1 2
1 3
2 4
1 2 4 3
예제 출력 2
1
예제 입력 3
4
1 2
1 3
2 4
1 3 2 4
예제 출력 3
1

 */
package baekjoon.basic_algorithm_2.graph_1_challenge;

import java.io.*;
import java.util.*;

public class BOJ16964 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> expectedOrder = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            expectedOrder.add(Integer.parseInt(st.nextToken()));

        int first = expectedOrder.poll();
        if (first != 1) {
            bw.write("0");
        } else {
            if (isValidDFS(1, 0)) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isValidDFS(int cur, int parent) {
        if (visited[cur])
            return true;

        visited[cur] = true;
        HashSet<Integer> neighbors = new HashSet<>();

        for (int next : graph.get(cur)) {
            if (next != parent) {
                neighbors.add(next);
            }
        }

        while (!neighbors.isEmpty()) {
            int expectedNode = expectedOrder.poll();
            if (neighbors.contains(expectedNode)) {
                neighbors.remove(expectedNode);
                if (!isValidDFS(expectedNode, cur)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
