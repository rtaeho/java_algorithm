/*
문제
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

예제 입력 1
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
예제 출력 1
5
28
0
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l; // 체스판의 크기
    static int[][] moves = { // 나이트의 이동 방향
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(startX, startY, targetX, targetY)); // BFS를 통한 최소 이동 횟수 계산
        }
    }

    private static int bfs(int startX, int startY, int targetX, int targetY) {
        boolean[][] visited = new boolean[l][l]; // 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0}); // {x, y, 이동 횟수}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int count = current[2];

            // 도착지에 도달한 경우
            if (curX == targetX && curY == targetY) {
                return count; // 최소 이동 횟수 반환
            }

            // 나이트의 이동
            for (int[] move : moves) {
                int nextX = curX + move[0];
                int nextY = curY + move[1];

                // 체스판 내에서 유효한 이동인지 확인
                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true; // 방문 체크
                    queue.add(new int[]{nextX, nextY, count + 1}); // 큐에 추가
                }
            }
        }

        return -1; // 도달할 수 없는 경우 (실제 상황에서는 발생하지 않음)
    }
}