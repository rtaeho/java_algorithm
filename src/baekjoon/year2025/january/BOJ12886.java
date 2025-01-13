/*
문제
오늘 강호는 돌을 이용해 재미있는 게임을 하려고 한다. 먼저, 돌은 세 개의 그룹으로 나누어져 있으며 각각의 그룹에는 돌이 A, B, C개가 있다. 강호는 모든 그룹에 있는 돌의 개수를 같게 만들려고 한다.

강호는 돌을 단계별로 움직이며, 각 단계는 다음과 같이 이루어져 있다.

크기가 같지 않은 두 그룹을 고른다. 그 다음, 돌의 개수가 작은 쪽을 X, 큰 쪽을 Y라고 정한다. 그 다음, X에 있는 돌의 개수를 X+X개로, Y에 있는 돌의 개수를 Y-X개로 만든다.

A, B, C가 주어졌을 때, 강호가 돌을 같은 개수로 만들 수 있으면 1을, 아니면 0을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 주어진다. (1 ≤ A, B, C ≤ 500)

출력
돌을 같은 개수로 만들 수 있으면 1을, 아니면 0을 출력한다.

예제 입력 1
10 15 35
예제 출력 1
1
예제 입력 2
1 1 2
예제 출력 2
0
 */
package baekjoon.year2025.january;

import java.io.*;
import java.util.*;

public class BOJ12886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 전체 돌의 합
        int total = A + B + C;

        // 전체 돌의 합이 3으로 나누어떨어지지 않으면 불가능
        if (total % 3 != 0) {
            System.out.println(0);
            return;
        }

        // BFS 탐색
        System.out.println(bfs(A, B, C) ? 1 : 0);
    }

    static boolean bfs(int A, int B, int C) {
        // 방문 체크 배열
        boolean[][] visited = new boolean[1501][1501];
        Queue<int[]> queue = new LinkedList<>();

        // 초기 상태 추가
        queue.add(new int[]{A, B, C});
        visited[A][B] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];

            // 세 그룹의 돌 개수가 같으면 성공
            if (x == y && y == z) {
                return true;
            }

            // 다음 상태 탐색
            int[] nextX = {x, y, z};
            int[] nextY = {y, z, x};

            for (int i = 0; i < 3; i++) {
                int small = Math.min(nextX[i], nextY[i]);
                int big = Math.max(nextX[i], nextY[i]);

                // 돌의 개수를 이동
                big -= small;
                small *= 2;

                int newA = nextX[(i + 2) % 3];
                int newB = small;
                int newC = big;

                // 정렬된 상태로 관리
                int[] sorted = {newA, newB, newC};
                Arrays.sort(sorted);

                if (!visited[sorted[0]][sorted[1]]) {
                    visited[sorted[0]][sorted[1]] = true;
                    queue.add(new int[]{sorted[0], sorted[1], sorted[2]});
                }
            }
        }
        return false;
    }
}
