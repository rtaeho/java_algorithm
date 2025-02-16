/*
문제
크기가 1×1인 정사각형으로 나누어진 W×H 크기의 지도가 있다. 지도의 각 칸은 빈 칸이거나 벽이며, 두 칸은 'C'로 표시되어 있는 칸이다.

'C'로 표시되어 있는 두 칸을 레이저로 통신하기 위해서 설치해야 하는 거울 개수의 최솟값을 구하는 프로그램을 작성하시오. 레이저로 통신한다는 것은 두 칸을 레이저로 연결할 수 있음을 의미한다.

레이저는 C에서만 발사할 수 있고, 빈 칸에 거울('/', '\')을 설치해서 방향을 90도 회전시킬 수 있다.

아래 그림은 H = 8, W = 7인 경우이고, 빈 칸은 '.', 벽은 '*'로 나타냈다. 왼쪽은 초기 상태, 오른쪽은 최소 개수의 거울을 사용해서 두 'C'를 연결한 것이다.

7 . . . . . . .         7 . . . . . . .
6 . . . . . . C         6 . . . . . /-C
5 . . . . . . *         5 . . . . . | *
4 * * * * * . *         4 * * * * * | *
3 . . . . * . .         3 . . . . * | .
2 . . . . * . .         2 . . . . * | .
1 . C . . * . .         1 . C . . * | .
0 . . . . . . .         0 . \-------/ .
  0 1 2 3 4 5 6           0 1 2 3 4 5 6
입력
첫째 줄에 W와 H가 주어진다. (1 ≤ W, H ≤ 100)

둘째 줄부터 H개의 줄에 지도가 주어진다. 지도의 각 문자가 의미하는 것은 다음과 같다.

.: 빈 칸
*: 벽
C: 레이저로 연결해야 하는 칸
'C'는 항상 두 개이고, 레이저로 연결할 수 있는 입력만 주어진다.

출력
첫째 줄에 C를 연결하기 위해 설치해야 하는 거울 개수의 최솟값을 출력한다.

예제 입력 1
7 8
.......
......C
......*
*****.*
....*..
....*..
.C..*..
.......
예제 출력 1
3
 */
import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x, y, dir, mirrors; // 좌표, 방향, 설치한 거울 개수

        public Node(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }

        // 거울 개수가 적은 순서대로 탐색
        @Override
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors;
        }
    }

    static int W, H;
    static char[][] map;
    static int[][][] visited; // (x, y)에서 특정 방향으로 온 경우의 최소 거울 개수 저장
    static List<int[]> lasers = new ArrayList<>();

    // 4방향 (우, 좌, 하, 상)
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        // 맵 입력 및 C 위치 찾기
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    lasers.add(new int[]{i, j});
                }
            }
        }

        // 시작과 끝 좌표
        int[] start = lasers.get(0);
        int[] end = lasers.get(1);

        // 결과 출력 (최소 거울 개수)
        System.out.println(bfs(start[0], start[1], end[0], end[1]));
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new int[H][W][4]; // 각 방향에 대해 최소 거울 개수를 저장
        for (int[][] row : visited) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        // 초기 시작점에서 4방향으로 출발
        for (int d = 0; d < 4; d++) {
            pq.add(new Node(sx, sy, d, 0));
            visited[sx][sy][d] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x, y = cur.y, dir = cur.dir, mirrors = cur.mirrors;

            // 목적지 도착
            if (x == ex && y == ey) {
                return mirrors;
            }

            // 현재 방향으로 계속 직진
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] != '*') {
                if (visited[nx][ny][dir] > mirrors) {
                    visited[nx][ny][dir] = mirrors;
                    pq.add(new Node(nx, ny, dir, mirrors));
                }
            }

            // 거울을 설치하여 90도 회전 (우 → 상, 하 / 좌 → 상, 하)
            for (int newDir = 0; newDir < 4; newDir++) {
                if (dir == newDir) {
                    continue; // 같은 방향이면 무시
                }
                if ((dir < 2 && newDir < 2) || (dir >= 2 && newDir >= 2)) {
                    continue; // 직진만 허용
                }

                if (visited[x][y][newDir] > mirrors + 1) {
                    visited[x][y][newDir] = mirrors + 1;
                    pq.add(new Node(x, y, newDir, mirrors + 1));
                }
            }
        }
        return -1; // 도달할 수 없는 경우 (문제 조건상 발생하지 않음)
    }
}