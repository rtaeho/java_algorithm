package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9328 {
    static int T, H, W;
    static char[][] building;
    static boolean[][] visited;
    static boolean[] havingKeys;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            building = new char[H][W];
            havingKeys = new boolean[26];

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    building[i][j] = line.charAt(j);
                }
            }

            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (char key : keys.toCharArray()) {
                    havingKeys[key - 'a'] = true;
                }
            }
            sb.append(bfs()).append('\n');
        }
        System.out.println(sb);
    }

    static int bfs() {
        int cnt = 0;
        while (true) {
            boolean foundNewKey = false;
            visited = new boolean[H][W];
            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (i == 0 || i == H - 1 || j == 0 || j == W - 1) {
                        if (building[i][j] != '*') {
                            if (building[i][j] >= 'A' && building[i][j] <= 'Z') {
                                if (!havingKeys[building[i][j] - 'A']) continue;
                            }
                            visited[i][j] = true;
                            queue.offer(new int[]{i, j});
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];

                if (building[y][x] == '$') {
                    cnt++;
                    building[y][x] = '.';
                } else if (building[y][x] >= 'a' && building[y][x] <= 'z') {
                    if (!havingKeys[building[y][x] - 'a']) {
                        havingKeys[building[y][x] - 'a'] = true;
                        foundNewKey = true;
                    }
                    building[y][x] = '.';
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny >= 0 && ny < H && nx >= 0 && nx < W && !visited[ny][nx] && building[ny][nx] != '*') {
                        char cell = building[ny][nx];
                        if (cell >= 'A' && cell <= 'Z' && !havingKeys[cell - 'A']) continue;

                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
            if (!foundNewKey) break;
        }
        return cnt;
    }
}