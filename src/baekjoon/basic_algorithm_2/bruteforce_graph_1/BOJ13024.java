/*
문제
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.

예제 입력 1
5 4
0 1
1 2
2 3
3 4
예제 출력 1
1
예제 입력 2
5 5
0 1
1 2
2 3
3 0
1 4
예제 출력 2
1
예제 입력 3
6 5
0 1
0 2
0 3
0 4
0 5
예제 출력 3
0
예제 입력 4
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
예제 출력 4
1
 */
package baekjoon.basic_algorithm_2.bruteforce_graph_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ13024 {
    static int N, M;
    static List<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Initialize adjacency list
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // Check for a path of length 4
        boolean result = false;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 0)) {
                result = true;
                break;
            }
        }

        System.out.println(result ? 1 : 0);
    }

    private static boolean dfs(int node, int depth) {
        if (depth == 4) {
            return true;
        }

        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, depth + 1)) {
                    return true;
                }
            }
        }
        visited[node] = false;
        return false;
    }
}