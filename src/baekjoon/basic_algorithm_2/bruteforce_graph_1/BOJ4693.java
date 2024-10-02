/*
문제
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.



한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

출력
각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

예제 입력 1
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
예제 출력 1
0
1
1
3
1
9
 */
package baekjoon.basic_algorithm_2.bruteforce_graph_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ4693 {
    static int w, h; // 지도 너비와 높이
    static int[][] map; // 지도 배열
    static boolean[][] visited; // 방문 체크 배열
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1}; // 이동할 x 좌표 (상, 하, 좌, 우, 대각선)
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1}; // 이동할 y 좌표 (상, 하, 좌, 우, 대각선)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break; // 입력 종료 조건

            // 지도 초기화
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int islandCount = 0; // 섬의 개수 초기화

            // 모든 정점을 탐색
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고 방문하지 않은 경우
                        dfs(i, j); // DFS 탐색
                        islandCount++; // 섬 개수 증가
                    }
                }
            }

            System.out.println(islandCount); // 섬 개수 출력
        }
    }

    // DFS 메소드
    private static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 정점 방문 체크

        for (int i = 0; i < 8; i++) { // 8방향 탐색 (상하좌우 + 대각선)
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 유효한 범위인지 및 방문 여부 체크
            if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w) {
                if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) { // 집이 있고 방문하지 않은 경우
                    dfs(nextX, nextY); // 재귀적으로 DFS 수행
                }
            }
        }
    }
}