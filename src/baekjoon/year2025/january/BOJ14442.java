/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

예제 입력 1
6 4 1
0100
1110
1000
0000
0111
0000
예제 출력 1
15
예제 입력 2
6 4 2
0100
1110
1000
0000
0111
0000
예제 출력 2
9
예제 입력 3
4 4 3
0111
1111
1111
1110
예제 출력 3
-1
 */
package baekjoon.year2025.january;

import java.io.*;
import java.util.*;

public class BOJ14442 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1]; // 벽 부수기 횟수를 포함한 방문 배열

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1}); // {x, y, 벽 부순 횟수, 거리}
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], broken = cur[2], dist = cur[3];

            // 목표 지점 도달
            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 맵의 범위 확인
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 빈 칸으로 이동
                    if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                        visited[nx][ny][broken] = true;
                        queue.add(new int[]{nx, ny, broken, dist + 1});
                    }

                    // 벽을 부수고 이동
                    if (map[nx][ny] == 1 && broken < K && !visited[nx][ny][broken + 1]) {
                        visited[nx][ny][broken + 1] = true;
                        queue.add(new int[]{nx, ny, broken + 1, dist + 1});
                    }
                }
            }
        }

        return -1; // 도달 불가능
    }
}