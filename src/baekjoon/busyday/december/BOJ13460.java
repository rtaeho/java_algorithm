/*
문제
스타트링크에서 판매하는 어린이용 장난감 중에서 가장 인기가 많은 제품은 구슬 탈출이다. 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.

보드의 세로 크기는 N, 가로 크기는 M이고, 편의상 1×1크기의 칸으로 나누어져 있다. 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다. 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.

이때, 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.

각각의 동작에서 공은 동시에 움직인다. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.

보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 보드의 세로, 가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로 이루어져 있다. '.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

입력되는 모든 보드의 가장자리에는 모두 '#'이 있다. 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.

출력
최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력한다. 만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.

예제 입력 1
5 5
#####
#..B#
#.#.#
#RO.#
#####
예제 출력 1
1
예제 입력 2
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
예제 출력 2
5
예제 입력 3
7 7
#######
#..R#B#
#.#####
#.....#
#####.#
#O....#
#######
예제 출력 3
5
예제 입력 4
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.#.#..#
#...#.O#.#
##########
예제 출력 4
-1
예제 입력 5
3 7
#######
#R.O.B#
#######
예제 출력 5
1
예제 입력 6
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.##...#
#O..#....#
##########
예제 출력 6
7
예제 입력 7
3 10
##########
#.O....RB#
##########
예제 출력 7
-1
 */
package baekjoon.busyday.december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13460 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited; // R과 B의 위치를 저장하는 방문 체크 배열
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.'; // 방문 후 빈칸으로 변경
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.'; // 방문 후 빈칸으로 변경
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rx, ry, bx, by, 0});
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int crx = cur[0], cry = cur[1], cbx = cur[2], cby = cur[3], depth = cur[4];

            // 10번 초과 시 실패
            if (depth >= 10) {
                return -1;
            }

            for (int d = 0; d < 4; d++) {
                // R과 B를 각각 한 방향으로 이동
                int[] nextRed = move(crx, cry, d);
                int[] nextBlue = move(cbx, cby, d);

                int nrx = nextRed[0], nry = nextRed[1];
                int nbx = nextBlue[0], nby = nextBlue[1];

                // 파란 구슬이 구멍에 빠지면 실패
                if (board[nbx][nby] == 'O') {
                    continue;
                }

                // 빨간 구슬이 구멍에 빠졌다면 성공
                if (board[nrx][nry] == 'O') {
                    return depth + 1;
                }

                // 두 구슬이 같은 위치에 있으면 더 많이 이동한 구슬을 한 칸 뒤로 이동
                if (nrx == nbx && nry == nby) {
                    if (nextRed[2] > nextBlue[2]) { // Red가 더 멀리 이동
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else { // Blue가 더 멀리 이동
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                // 방문하지 않은 상태라면 큐에 추가
                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.add(new int[]{nrx, nry, nbx, nby, depth + 1});
                }
            }
        }
        return -1; // 실패
    }

    static int[] move(int x, int y, int d) {
        int dist = 0;
        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 벽을 만나거나 구멍을 만나면 이동 종료
            if (board[nx][ny] == '#' || board[x][y] == 'O') {
                break;
            }

            x = nx;
            y = ny;
            dist++;
        }
        return new int[]{x, y, dist};
    }
}