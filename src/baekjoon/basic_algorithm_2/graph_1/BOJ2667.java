/*
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1
3
7
8
9
 */
package baekjoon.basic_algorithm_2.graph_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ2667 {
    static int N; // 지도의 크기
    static int[][] map; // 지도 배열
    static boolean[][] visited; // 방문 체크 배열
    static int[] dx = {0, 0, 1, -1}; // 이동할 x 좌표 (우, 좌, 하, 상)
    static int[] dy = {1, -1, 0, 0}; // 이동할 y 좌표 (우, 좌, 하, 상)
    static List<Integer> houseCounts = new ArrayList<>(); // 각 단지의 집 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도 크기 입력
        map = new int[N][N]; // 지도 초기화
        visited = new boolean[N][N]; // 방문 배열 초기화

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 '0' 또는 '1'을 정수로 변환
            }
        }

        // 단지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 집이 있고, 방문하지 않은 경우
                    houseCounts.add(bfs(i, j)); // BFS로 단지 내 집 개수 탐색
                }
            }
        }

        // 결과 출력
        Collections.sort(houseCounts); // 집 개수를 오름차순으로 정렬
        System.out.println(houseCounts.size()); // 총 단지 수 출력
        for (int count : houseCounts) {
            System.out.println(count); // 각 단지 내 집 개수 출력
        }
    }

    // BFS 메소드
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // 시작 정점을 큐에 추가
        visited[x][y] = true; // 방문 체크
        int count = 1; // 현재 단지 내 집 개수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) { // 4방향 탐색
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 유효한 범위인지 및 방문 여부 체크
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) { // 집이 있고 방문하지 않은 경우
                        queue.add(new int[]{nextX, nextY}); // 큐에 추가
                        visited[nextX][nextY] = true; // 방문 체크
                        count++; // 집 개수 증가
                    }
                }
            }
        }
        return count; // 현재 단지 내 집 개수 반환
    }
}