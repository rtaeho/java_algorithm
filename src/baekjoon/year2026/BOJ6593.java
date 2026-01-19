package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593 {
    // 동서남북상하
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int l, r, c;
    static int[][][] room;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                line = br.readLine();
            }

            st = new StringTokenizer(line);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            room = new int[l][r][c];
            queue = new LinkedList<>();
            int[] exit = new int[3];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char c = str.charAt(k);
                        if (c == 'S') { // 시작
                            queue.add(new int[]{i, j, k});
                            room[i][j][k] = 0;
                        } else if (c == '#') { // 벽
                            room[i][j][k] = -1;
                        } else if (c == 'E') { // 출구
                            exit = new int[]{i, j, k};
                            room[i][j][k] = -2;
                        } else { // 나머지
                            room[i][j][k] = -3;
                        }
                    }
                }
                br.readLine(); // 개행 제거
            }

            int result = bfs();
            if (result == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int i = 0; i < 6; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                int tz = z + dz[i];

                if (tx >= 0 && tx < c && ty >= 0 && ty < r && tz >= 0 && tz < l) {
                    if (room[tz][ty][tx] == -2) {
                        return room[z][y][x] + 1;
                    }
                    if (room[tz][ty][tx] == -3) {
                        room[tz][ty][tx] = room[z][y][x] + 1;
                        queue.add(new int[]{tz, ty, tx});
                    }
                }
            }
        }
        return -1;
    }
}