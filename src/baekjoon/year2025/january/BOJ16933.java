/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다. 이동하지 않고 같은 칸에 머물러있는 경우도 가능하다. 이 경우도 방문한 칸의 개수가 하나 늘어나는 것으로 생각해야 한다.

이번 문제에서는 낮과 밤이 번갈아가면서 등장한다. 가장 처음에 이동할 때는 낮이고, 한 번 이동할 때마다 낮과 밤이 바뀌게 된다. 이동하지 않고 같은 칸에 머무르는 경우에도 낮과 밤이 바뀌게 된다.

만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다. 단, 벽은 낮에만 부술 수 있다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

예제 입력 1
1 4 1
0010
예제 출력 1
5
예제 입력 2
1 4 1
0100
예제 출력 2
4
예제 입력 3
6 4 1
0100
1110
1000
0000
0111
0000
예제 출력 3
15
예제 입력 4
6 4 2
0100
1110
1000
0000
0111
0000
예제 출력 4
9
 */
package baekjoon.year2025.january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, dist, boom, day;

    Node(int x, int y, int dist, int boom, int day) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.boom = boom;
        this.day = day;
    }
}

public class BOJ16933 {

    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int map[][];
    static boolean visit[][][][];
    static int n, m, k, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m][k + 1][2];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        ans = -1;
        bfs();

        System.out.println(ans);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0, 0)); //x, y, dist, boom, day
        visit[0][0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            if (x == n - 1 && y == m - 1) {
                ans = now.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 > nx || nx >= n || 0 > ny || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (now.day == 0 && !visit[nx][ny][now.boom][now.day + 1]) {
                        q.add(new Node(nx, ny, now.dist + 1, now.boom, now.day + 1));
                        visit[nx][ny][now.boom][now.day + 1] = true;
                    } else if (now.day == 1 && !visit[nx][ny][now.boom][now.day - 1]) {
                        q.add(new Node(nx, ny, now.dist + 1, now.boom, now.day - 1));
                        visit[nx][ny][now.boom][now.day - 1] = true;
                    }
                } else { //낮은 0 밤은 1
                    if (now.boom < k && now.day == 0 && !visit[nx][ny][now.boom + 1][now.day + 1]) {
                        visit[nx][ny][now.boom + 1][now.day + 1] = true;
                        q.add(new Node(nx, ny, now.dist + 1, now.boom + 1, now.day + 1));
                    } else if (now.boom < k && now.day == 1 && !visit[x][y][now.boom][now.day - 1]) {
                        visit[x][y][now.boom][now.day - 1] = true;
                        q.add(new Node(x, y, now.dist + 1, now.boom, now.day - 1));
                    }
                }

            }

        }

    }

}
