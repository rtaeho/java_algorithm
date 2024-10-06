/*]문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1
4 6
101111
101010
101011
111011
예제 출력 1
15
예제 입력 2
4 6
110110
110110
111111
111101
예제 출력 2
9
예제 입력 3
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3
38
예제 입력 4
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4
13
 */
package baekjoon.basic_algorithm_2.graph_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N, M; // 미로의 크기
    static int[][] maze; // 미로 배열
    static boolean[][] visited; // 방문 체크 배열
    static int[] dx = {0, 0, 1, -1}; // 이동할 x 좌표 (우, 좌, 하, 상)
    static int[] dy = {1, -1, 0, 0}; // 이동할 y 좌표 (우, 좌, 하, 상)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 미로 초기화
        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0'; // 문자 '0' 또는 '1'을 정수로 변환
            }
        }

        System.out.println(bfs(0, 0)); // (0, 0)에서 BFS 시작
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        // 시작점 방문 체크 및 거리 초기화
        int[][] distance = new int[N][M];
        distance[startX][startY] = 1; // 시작 위치는 1로 설정

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) { // 4방향 탐색
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 유효한 범위인지 및 이동 가능 여부 체크
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (maze[nextX][nextY] == 1 && distance[nextX][nextY] == 0) { // 이동할 수 있는 칸
                        queue.add(new int[]{nextX, nextY}); // 큐에 추가
                        distance[nextX][nextY] = distance[curX][curY] + 1; // 거리 업데이트
                    }
                }
            }
        }

        return distance[N - 1][M - 1]; // 도착 위치의 거리 반환
    }
}