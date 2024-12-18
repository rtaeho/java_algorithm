/*
문제
게임을 좋아하는 큐브러버는 체스에서 사용할 새로운 말 "데스 나이트"를 만들었다. 데스 나이트가 있는 곳이 (r, c)라면, (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)로 이동할 수 있다.

크기가 N×N인 체스판과 두 칸 (r1, c1), (r2, c2)가 주어진다. 데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 구해보자. 체스판의 행과 열은 0번부터 시작한다.

데스 나이트는 체스판 밖으로 벗어날 수 없다.

입력
첫째 줄에 체스판의 크기 N(5 ≤ N ≤ 200)이 주어진다. 둘째 줄에 r1, c1, r2, c2가 주어진다.

출력
첫째 줄에 데스 나이트가 (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 출력한다. 이동할 수 없는 경우에는 -1을 출력한다.

예제 입력 1
7
6 6 0 1
예제 출력 1
4
예제 입력 2
6
5 1 0 5
예제 출력 2
-1
예제 입력 3
7
0 3 4 3
예제 출력 3
2
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N; // 체스판 크기
    static int[][] directions = { // 데스 나이트의 이동 방향
            {-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.println(bfs(r1, c1, r2, c2));
    }

    // BFS로 최단 거리 계산
    static int bfs(int r1, int c1, int r2, int c2) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1, 0}); // {행, 열, 이동 횟수}
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int moves = cur[2];

            // 목표 위치에 도달하면 이동 횟수 반환
            if (x == r2 && y == c2) {
                return moves;
            }

            // 다음 이동 위치 탐색
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 체스판 범위 내에 있고, 방문하지 않은 경우
                if (isInBounds(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }

        // 목표 위치에 도달할 수 없는 경우
        return -1;
    }

    // 체스판 범위 확인
    static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
