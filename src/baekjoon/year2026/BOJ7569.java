package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    // 6방향
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] tomatoBox;
    static int m, n, h;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tomatoBox = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoBox[i][j][k] == 1) {
                        queue.add(new int[]{k, j, i});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 6; i++) {
                int tx = cur[0] + dx[i];
                int ty = cur[1] + dy[i];
                int tz = cur[2] + dz[i];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && tz >= 0 && tz < h) {
                    if (tomatoBox[tz][ty][tx] == 0) {
                        tomatoBox[tz][ty][tx] = tomatoBox[cur[2]][cur[1]][cur[0]] + 1;
                        queue.add(new int[]{tx, ty, tz});
                    }
                }

            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoBox[i][j][k] == 0) {
                        return -1;
                    }
                    maxDays = Math.max(maxDays, tomatoBox[i][j][k]);
                }
            }
        }
        return maxDays - 1;
    }
}
