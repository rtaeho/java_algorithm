package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427 {
    static char[][] map;
    static int w, h;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> humanQueue;
    static Queue<int[]> fireQueue;
    static int[][] fireMap;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            humanQueue = new LinkedList<>();
            fireQueue = new LinkedList<>();
            fireMap = new int[h][w];
            visited = new boolean[h][w];
            for (int y = 0; y < h; y++) {
                String str = br.readLine();
                Arrays.fill(fireMap[y], -1);
                for (int x = 0; x < w; x++) {
                    map[y][x] = str.charAt(x);
                    if (map[y][x] == '@') {
                        humanQueue.offer(new int[]{y, x, 0});
                        visited[y][x] = true;
                    } else if (map[y][x] == '*') {
                        fireQueue.offer(new int[]{y, x, 0});
                        fireMap[y][x] = 0;
                    }
                }
            }
            bfsFire();
            int answer = bfsHuman();

            if (answer == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void bfsFire() {
        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int y = current[0];
            int x = current[1];
            int time = current[2];
            fireMap[y][x] = time;
            for (int dir = 0; dir < 4; dir++) {
                int ty = y + dy[dir];
                int tx = x + dx[dir];
                if (ty >= 0 && ty < h && tx >= 0 && tx < w) {
                    if (map[ty][tx] != '#' && fireMap[ty][tx] == -1) {
                        fireMap[ty][tx] = time + 1;
                        fireQueue.offer(new int[]{ty, tx, time + 1});
                    }
                }
            }
        }
    }

    private static int bfsHuman() {
        visited = new boolean[h][w];
        int time = -1;
        while (!humanQueue.isEmpty()) {
            int[] current = humanQueue.poll();
            int y = current[0];
            int x = current[1];
            int curTime = current[2];

            for (int dir = 0; dir < 4; dir++) {
                int ty = y + dy[dir];
                int tx = x + dx[dir];

                if (ty < 0 || ty >= h || tx < 0 || tx >= w) {
                    return curTime + 1;
                }

                if (map[ty][tx] == '.' && !visited[ty][tx]) {
                    if (fireMap[ty][tx] == -1 || fireMap[ty][tx] > curTime + 1) {
                        visited[ty][tx] = true;
                        humanQueue.offer(new int[]{ty, tx, curTime + 1});
                    }
                }

            }
        }
        return time;
    }
}