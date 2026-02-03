package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> lakeQueue = new LinkedList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char cell = str.charAt(j);
                if (cell == '.') {
                    lakeQueue.offer(new int[]{i, j});
                }
                // 백조가 서 있는 곳도 녹겠지?
                else if (cell == 'L') {
                    lakeQueue.offer(new int[]{i, j});
                    if (swanQueue.isEmpty()) {
                        swanQueue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
                map[i][j] = cell;
            }
        }
        int days = 0;
        while (true) {
            if (swanBFS()) {
                break;
            }
            lakeBFS();
            days++;
        }
        System.out.println(days);
    }

    static void lakeBFS() {
        Queue<int[]> newLakeQueue = new LinkedList<>();
        int size = lakeQueue.size();
        for (int i = 0; i < size; i++) {
            int[] cur = lakeQueue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (map[ny][nx] == 'X') {
                        map[ny][nx] = '.';
                        newLakeQueue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        lakeQueue = newLakeQueue;

    }

    static boolean swanBFS() {
        Queue<int[]> newSwanQueue = new LinkedList<>();
        while (!swanQueue.isEmpty()) {
            int[] cur = swanQueue.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (visited[ny][nx]) {
                        continue;
                    }
                    visited[ny][nx] = true;
                    if (map[ny][nx] == '.') {
                        swanQueue.offer(new int[]{ny, nx});
                    } else if (map[ny][nx] == 'L') {
                        return true;
                    } else if (map[ny][nx] == 'X') {
                        newSwanQueue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        swanQueue = newSwanQueue;
        return false;
    }
}
