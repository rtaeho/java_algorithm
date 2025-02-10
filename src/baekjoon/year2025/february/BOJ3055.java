/*
문제
사악한 암흑의 군주 이민혁은 드디어 마법 구슬을 손에 넣었고, 그 능력을 실험해보기 위해 근처의 티떱숲에 홍수를 일으키려고 한다. 이 숲에는 고슴도치가 한 마리 살고 있다. 고슴도치는 제일 친한 친구인 비버의 굴로 가능한 빨리 도망가 홍수를 피하려고 한다.

티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.

매 분마다 고슴도치는 현재 있는 칸과 인접한 네 칸 중 하나로 이동할 수 있다. (위, 아래, 오른쪽, 왼쪽) 물도 매 분마다 비어있는 칸으로 확장한다. 물이 있는 칸과 인접해있는 비어있는 칸(적어도 한 변을 공유)은 물이 차게 된다. 물과 고슴도치는 돌을 통과할 수 없다. 또, 고슴도치는 물로 차있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 이동할 수 없다.

티떱숲의 지도가 주어졌을 때, 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간을 구하는 프로그램을 작성하시오.

고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.

입력
첫째 줄에 50보다 작거나 같은 자연수 R과 C가 주어진다.

다음 R개 줄에는 티떱숲의 지도가 주어지며, 문제에서 설명한 문자만 주어진다. 'D'와 'S'는 하나씩만 주어진다.

출력
첫째 줄에 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 출력한다. 만약, 안전하게 비버의 굴로 이동할 수 없다면, "KAKTUS"를 출력한다.

예제 입력 1
3 3
D.*
...
.S.
예제 출력 1
3
예제 입력 2
3 3
D.*
...
..S
예제 출력 2
KAKTUS
예제 입력 3
3 6
D...*.
.X.X..
....S.
예제 출력 3
6
예제 입력 4
5 4
.D.*
....
..X.
S.*.
....
예제 출력 4
4
 */
package baekjoon.year2025.february;

import java.io.*;
import java.util.*;

public class BOJ3055 {
    static int R, C;
    static char[][] forest;
    static int[][] waterTime; // 물이 차는 시간 기록
    static int[][] dist; // 고슴도치의 이동 시간 기록
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1};

    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> hedgehogQueue = new LinkedList<>();

    static int startX, startY; // 고슴도치 시작 위치
    static int endX, endY; // 비버 굴 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        forest = new char[R][C];
        waterTime = new int[R][C];
        dist = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(waterTime[i], -1); // 물이 차지 않은 곳을 -1로 초기화
            Arrays.fill(dist[i], -1); // 방문하지 않은 곳을 -1로 초기화
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                forest[i][j] = line.charAt(j);

                if (forest[i][j] == 'S') { // 고슴도치 위치
                    startX = i;
                    startY = j;
                    dist[i][j] = 0;
                    hedgehogQueue.add(new int[]{i, j});
                }
                else if (forest[i][j] == 'D') { // 비버의 굴 위치
                    endX = i;
                    endY = j;
                }
                else if (forest[i][j] == '*') { // 물의 시작 위치
                    waterQueue.add(new int[]{i, j});
                    waterTime[i][j] = 0; // 물이 차 있는 곳은 시간 0
                }
            }
        }

        // 1️⃣ 먼저 물을 확장
        spreadWater();

        // 2️⃣ 고슴도치 이동 시도
        int result = moveHedgehog();

        // 결과 출력
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    // **물의 BFS 탐색** (물이 차는 시간 계산)
    static void spreadWater() {
        while (!waterQueue.isEmpty()) {
            int[] cur = waterQueue.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 범위 초과
                if (forest[nx][ny] == 'X' || forest[nx][ny] == 'D') continue; // 돌 또는 비버 굴이면 이동 불가
                if (waterTime[nx][ny] != -1) continue; // 이미 물이 찬 곳이면 패스

                waterTime[nx][ny] = waterTime[x][y] + 1;
                waterQueue.add(new int[]{nx, ny});
            }
        }
    }

    // **고슴도치 BFS 탐색** (최단 거리 찾기)
    static int moveHedgehog() {
        while (!hedgehogQueue.isEmpty()) {
            int[] cur = hedgehogQueue.poll();
            int x = cur[0], y = cur[1];

            // 비버의 굴 도착 시 종료
            if (x == endX && y == endY) {
                return dist[x][y];
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 범위 초과
                if (forest[nx][ny] == 'X') continue; // 돌이면 이동 불가
                if (dist[nx][ny] != -1) continue; // 이미 방문한 곳이면 패스

                // 물이 차지 않은 안전한 칸만 이동 가능
                if (waterTime[nx][ny] == -1 || dist[x][y] + 1 < waterTime[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + 1;
                    hedgehogQueue.add(new int[]{nx, ny});
                }
            }
        }
        return -1; // 도착 불가능하면 "KAKTUS"
    }
}
