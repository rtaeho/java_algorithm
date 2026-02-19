import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> hedgehogQueue = new LinkedList<>();
    static int[][] waterVisited;
    static int[][] hedgehogVisited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        waterVisited = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(waterVisited[i], -1);
        }
        hedgehogVisited = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(hedgehogVisited[i], -1);
        }
        Arrays.fill(hedgehogVisited[0], -1);
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                    waterVisited[i][j] = 0;
                } else if (map[i][j] == 'S') {
                    hedgehogQueue.offer(new int[]{i, j});
                    hedgehogVisited[i][j] = 0;
                }
            }
        }
        waterBFS();
        hedgehogBFS();
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }

    static void waterBFS() {
        while (!waterQueue.isEmpty()) {
            int size = waterQueue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = waterQueue.poll();
                int r = cur[0];
                int c = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (waterVisited[nr][nc] == -1 && map[nr][nc] == '.') {
                            waterVisited[nr][nc] = waterVisited[r][c] + 1;
                            waterQueue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }

    static void hedgehogBFS() {
        while (!hedgehogQueue.isEmpty()) {
            int[] cur = hedgehogQueue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (hedgehogVisited[nr][nc] == -1 && map[nr][nc] != 'X') {
                        if (map[nr][nc] == 'D') {
                            answer = hedgehogVisited[r][c] + 1;
                            return;
                        }
                        if (waterVisited[nr][nc] != -1 && waterVisited[nr][nc] <= hedgehogVisited[r][c] + 1) {
                            continue;
                        }
                        if (map[nr][nc] == '.') {
                            hedgehogVisited[nr][nc] = hedgehogVisited[r][c] + 1;
                            hedgehogQueue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
    }
}