/*
문제
N×M 크기의 보드와 4개의 버튼으로 이루어진 게임이 있다. 보드는 1×1크기의 정사각형 칸으로 나누어져 있고, 각각의 칸은 비어있거나, 벽이다. 두 개의 빈 칸에는 동전이 하나씩 놓여져 있고, 두 동전의 위치는 다르다.

버튼은 "왼쪽", "오른쪽", "위", "아래"와 같이 4가지가 있다. 버튼을 누르면 두 동전이 버튼에 쓰여 있는 방향으로 동시에 이동하게 된다.

동전이 이동하려는 칸이 벽이면, 동전은 이동하지 않는다.
동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다.
그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다.이동하려는 칸에 동전이 있는 경우에도 한 칸 이동한다.
두 동전 중 하나만 보드에서 떨어뜨리기 위해 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 20)

둘째 줄부터 N개의 줄에는 보드의 상태가 주어진다.

o: 동전
.: 빈 칸
#: 벽
동전의 개수는 항상 2개이다.

출력
첫째 줄에 두 동전 중 하나만 보드에서 떨어뜨리기 위해 눌러야 하는 버튼의 최소 횟수를 출력한다. 만약, 두 동전을 떨어뜨릴 수 없거나, 버튼을 10번보다 많이 눌러야 한다면, -1을 출력한다.

예제 입력 1
1 2
oo
예제 출력 1
1
예제 입력 2
6 2
.#
.#
.#
o#
o#
##
예제 출력 2
4
예제 입력 3
6 2
..
..
..
o#
o#
##
예제 출력 3
3
예제 입력 4
5 3
###
.o.
###
.o.
###
예제 출력 4
-1
예제 입력 5
5 3
###
.o.
#.#
.o.
###
예제 출력 5
3
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map; // 보드 상태
    static int N, M; // 보드의 크기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 보드의 크기 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Point coin1 = null; // 첫 번째 동전
        Point coin2 = null; // 두 번째 동전

        // 보드 상태 입력 및 동전 위치 저장
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'o') {
                    if (coin1 == null) {
                        coin1 = new Point(i, j); // 첫 번째 동전
                    } else {
                        coin2 = new Point(i, j); // 두 번째 동전
                    }
                }
            }
        }

        System.out.printf("%d", bfs(coin1, coin2)); // BFS로 결과 출력
    }

    public static int bfs(Point coin1, Point coin2) {
        Queue<Point[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 이동 방향 (오른쪽, 아래, 왼쪽, 위)

        // 초기 동전 위치를 큐에 추가
        q.add(new Point[]{coin1, coin2});
        String start = coin1.x + "," + coin1.y + "," + coin2.x + "," + coin2.y; // 초기 위치 문자열
        visited.add(start); // 방문 체크

        int depth = 0; // 버튼 클릭 수

        while (!q.isEmpty()) {
            depth++;
            if (depth > 10) {
                return -1; // 10번 이상 클릭 시 종료
            }

            int len = q.size();
            for (int l = 0; l < len; l++) {
                Point[] now = q.poll();

                // 각 방향으로 동전 이동
                for (int i = 0; i < 4; i++) {
                    int nx1 = now[0].x + dist[i][0];
                    int ny1 = now[0].y + dist[i][1];

                    int nx2 = now[1].x + dist[i][0];
                    int ny2 = now[1].y + dist[i][1];

                    // 동전 이동 가능성 체크
                    if ((!isIn(nx1, ny1) && isIn(nx2, ny2)) || (isIn(nx1, ny1) && !isIn(nx2, ny2))) {
                        return depth; // 한 동전만 떨어진 경우
                    }
                    if ((!isIn(nx1, ny1) && !isIn(nx2, ny2))) {
                        continue; // 두 동전 모두 떨어진 경우
                    }

                    // 벽에 부딪혔을 경우 처리
                    if (map[nx1][ny1] == '#' && map[nx2][ny2] == '#') {
                        continue; // 둘 다 벽
                    }

                    if (map[nx1][ny1] == '#' && map[nx2][ny2] != '#') {
                        if (now[0].x == nx2 && now[0].y == ny2) {
                            continue; // 이동한 위치가 현재 동전 위치와 같을 경우
                        }
                        nx1 = now[0].x; // 원래 위치로 복귀
                        ny1 = now[0].y;
                    } else if (map[nx1][ny1] != '#' && map[nx2][ny2] == '#') {
                        if (now[1].x == nx1 && now[1].y == ny1) {
                            continue; // 이동한 위치가 현재 동전 위치와 같을 경우
                        }
                        nx2 = now[1].x; // 원래 위치로 복귀
                        ny2 = now[1].y;
                    }

                    String next = nx1 + "," + ny1 + "," + nx2 + "," + ny2; // 다음 위치 문자열
                    if (visited.contains(next)) {
                        continue; // 이미 방문한 경우
                    }

                    visited.add(next); // 방문 기록
                    q.add(new Point[]{new Point(nx1, ny1), new Point(nx2, ny2)}); // 큐에 추가
                }
            }
        }
        return -1; // 동전을 떨어뜨릴 수 없는 경우
    }

    public static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M; // 범위 체크
    }
}