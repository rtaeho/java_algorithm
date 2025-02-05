/*
문제
욱제는 학교 숙제로 크기가 8×8인 체스판에서 탈출하는 게임을 만들었다. 체스판의 모든 칸은 빈 칸 또는 벽 중 하나이다. 욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.

이 게임의 특징은 벽이 움직인다는 점이다. 1초마다 모든 벽이 아래에 있는 행으로 한 칸씩 내려가고, 가장 아래에 있어서 아래에 행이 없다면 벽이 사라지게 된다. 욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다. 이동할 때는 빈 칸으로만 이동할 수 있다.

1초 동안 욱제의 캐릭터가 먼저 이동하고, 그 다음 벽이 이동한다. 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.

욱제의 캐릭터가 가장 오른쪽 윗 칸으로 이동할 수 있는지 없는지 구해보자.

입력
8개 줄에 걸쳐서 체스판의 상태가 주어진다. '.'은 빈 칸, '#'는 벽이다. 가장 왼쪽 아랫칸은 항상 벽이 아니다.

출력
욱제의 캐릭터가 가장 오른쪽 윗 칸에 도착할 수 있으면 1, 없으면 0을 출력한다.

예제 입력 1
........
........
........
........
........
........
........
........
예제 출력 1
1
예제 입력 2
........
........
........
........
........
........
##......
........
예제 출력 2
0
예제 입력 3
........
........
........
........
........
.#......
#.......
.#......
예제 출력 3
0
예제 입력 4
........
........
........
........
........
.#######
#.......
........
예제 출력 4
1
예제 입력 5
........
........
........
........
#.......
.#######
#.......
........
예제 출력 5
0
 */
package baekjoon.year2025.february;

import java.io.*;
import java.util.*;

public class BOJ16954 {
    static final int SIZE = 8;
    static char[][] board = new char[SIZE][SIZE];
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1, 0};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            board[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs() ? 1 : 0);
    }

    static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{7, 0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], time = cur[2];

                if (x == 0 && y == 7) {
                    return true;
                }

                if (board[x][y] == '#') {
                    continue;
                }

                for (int d = 0; d < 9; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) {
                        continue;
                    }

                    if (board[nx][ny] == '.') {
                        queue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }

            moveWalls();
        }

        return false;
    }

    static void moveWalls() {
        for (int i = SIZE - 1; i > 0; i--) {
            board[i] = board[i - 1].clone();
        }
        Arrays.fill(board[0], '.');
    }
}
