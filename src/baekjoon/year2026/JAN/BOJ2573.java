package baekjoon.year2026.JAN;

import java.io.*;
import java.util.*;

public class BOJ2573 {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            // 1. 빙산 덩어리 개수 세기
            int count = countIsland();

            if (count >= 2) { // 두 덩어리 이상 분리됨
                System.out.println(year);
                break;
            } else if (count == 0) { // 다 녹을 때까지 분리 안 됨
                System.out.println(0);
                break;
            }

            // 2. 빙산 녹이기
            melt();
            year++;
        }
    }

    // 빙산 덩어리 개수를 반환하는 메서드 (BFS)
    static int countIsland() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] > 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    // 인접한 바다(0)의 개수만큼 빙산을 녹이는 메서드
    static void melt() {
        int[][] seaCount = new int[N][M];

        // 각 칸 주변의 바다 개수 파악
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
                            count++;
                        }
                    }
                    seaCount[i][j] = count;
                }
            }
        }

        // 실제로 빙산 녹이기 (동시성 보장)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] -= seaCount[i][j];
                if (map[i][j] < 0) map[i][j] = 0;
            }
        }
    }
}