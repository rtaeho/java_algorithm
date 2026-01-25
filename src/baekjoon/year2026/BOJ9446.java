package baekjoon.year2026;

import java.io.*;
import java.util.*;

public class BOJ9446 {
    static int n, count;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0; // 팀이 된 사람의 수

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }
            // 전체 학생 수 - 팀에 성공한 학생 수
            System.out.println(n - count);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            // 이미 방문했지만, 탐색이 완전히 종료되지 않은 노드라면 사이클 발견!
            if (!finished[next]) {
                // 사이클에 포함된 노드들의 개수를 센다
                count++;
                for (int i = next; i != now; i = arr[i]) {
                    count++;
                }
            }
        }

        // 해당 노드의 모든 탐색(사이클 확인 포함)이 종료됨을 표시
        finished[now] = true;
    }
}