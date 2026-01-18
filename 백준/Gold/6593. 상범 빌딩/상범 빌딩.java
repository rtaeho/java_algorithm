import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] map;
    static int[][][] dist;
    // 6방향 (상, 하, 북, 남, 동, 서)
    static int[] dl = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break; // 종료 조건

            map = new char[L][R][C];
            dist = new int[L][R][C];
            int sl = 0, sr = 0, sc = 0; // 시작 지점 저장용

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = line.charAt(k);
                        dist[i][j][k] = -1; // 미방문 표시
                        if (map[i][j][k] == 'S') {
                            sl = i; sr = j; sc = k;
                            dist[i][j][k] = 0;
                        }
                    }
                }
                br.readLine(); // 층 사이의 빈 줄 처리
            }

            bfs(sl, sr, sc);
        }
    }

    static void bfs(int sl, int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sl, sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int l = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (map[l][r][c] == 'E') {
                System.out.println("Escaped in " + dist[l][r][c] + " minute(s).");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nl = l + dl[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (map[nl][nr][nc] != '#' && dist[nl][nr][nc] == -1) {
                        dist[nl][nr][nc] = dist[l][r][c] + 1;
                        q.add(new int[]{nl, nr, nc});
                    }
                }
            }
        }
        System.out.println("Trapped!");
    }
}