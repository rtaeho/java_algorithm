/*
문제
여러 섬으로 이루어진 나라가 있다. 이 나라의 대통령은 섬을 잇는 다리를 만들겠다는 공약으로 인기몰이를 해 당선될 수 있었다. 하지만 막상 대통령에 취임하자, 다리를 놓는다는 것이 아깝다는 생각을 하게 되었다. 그래서 그는, 생색내는 식으로 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 하였고, 그 또한 다리를 가장 짧게 하여 돈을 아끼려 하였다.

이 나라는 N×N크기의 이차원 평면상에 존재한다. 이 나라는 여러 섬으로 이루어져 있으며, 섬이란 동서남북으로 육지가 붙어있는 덩어리를 말한다. 다음은 세 개의 섬으로 이루어진 나라의 지도이다.



위의 그림에서 색이 있는 부분이 육지이고, 색이 없는 부분이 바다이다. 이 바다에 가장 짧은 다리를 놓아 두 대륙을 연결하고자 한다. 가장 짧은 다리란, 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리를 말한다. 다음 그림에서 두 대륙을 연결하는 다리를 볼 수 있다.



물론 위의 방법 외에도 다리를 놓는 방법이 여러 가지 있으나, 위의 경우가 놓는 다리의 길이가 3으로 가장 짧다(물론 길이가 3인 다른 다리를 놓을 수 있는 방법도 몇 가지 있다).

지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.

입력
첫 줄에는 지도의 크기 N(100이하의 자연수)가 주어진다. 그 다음 N줄에는 N개의 숫자가 빈칸을 사이에 두고 주어지며, 0은 바다, 1은 육지를 나타낸다. 항상 두 개 이상의 섬이 있는 데이터만 입력으로 주어진다.

출력
첫째 줄에 가장 짧은 다리의 길이를 출력한다.

예제 입력 1
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
예제 출력 1
3
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 하, 상, 우, 좌
    static Queue<int[]> queue = new LinkedList<>();
    static int[] island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCount = 0;
        visited = new boolean[N][N];

        // 각 섬에 번호를 매기고 섬을 탐색하여 좌표를 큐에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    bfs(i, j, islandCount); // 섬 탐색
                }
            }
        }

        int minBridgeLength = Integer.MAX_VALUE;

        // 다리의 최소 길이를 계산
        for (int k = 1; k <= islandCount; k++) {
            minBridgeLength = Math.min(minBridgeLength, findShortestBridge(k));
        }

        System.out.println(minBridgeLength);
    }

    // 섬의 좌표를 큐에 저장하고 섬의 번호를 매김
    private static void bfs(int x, int y, int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandNum;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : direction) {
                int nx = current[0] + dir[0];
                int ny = current[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = islandNum;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 섬과 바다 사이의 최소 다리 길이 계산
    private static int findShortestBridge(int islandNum) {
        boolean[][] bridgeVisited = new boolean[N][N];
        Queue<int[]> bridgeQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandNum) {
                    bridgeQueue.add(new int[]{i, j, 0}); // (x, y, length)
                    bridgeVisited[i][j] = true;
                }
            }
        }

        while (!bridgeQueue.isEmpty()) {
            int[] current = bridgeQueue.poll();
            int x = current[0];
            int y = current[1];
            int length = current[2];

            for (int[] dir : direction) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] != 0 && map[nx][ny] != islandNum) {
                        return length; // 다리 길이 리턴
                    }
                    if (!bridgeVisited[nx][ny] && map[nx][ny] == 0) {
                        bridgeVisited[nx][ny] = true;
                        bridgeQueue.add(new int[]{nx, ny, length + 1});
                    }
                }
            }
        }

        return Integer.MAX_VALUE; // 다리를 놓을 수 없는 경우
    }
}
