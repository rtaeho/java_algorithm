package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18809 {
    static class Plant {
        int time;
        int color; // 초록 3, 빨강 4

        Plant(int time, int color) {
            this.time = time;
            this.color = color;
        }
    }

    static int[][] map;
    static int N, M, G, R;
    static List<int[]> seedPoints = new LinkedList<>();
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    seedPoints.add(new int[]{i, j});
                }
            }
        }
        seed(0, 0, 0);
        System.out.println(answer);
    }

    static void seed(int idx, int Gcnt, int Rcnt) {
        if (Gcnt == G && Rcnt == R) {
            bfs();
            return;
        }
        if (idx >= seedPoints.size()) {
            return;
        }

        int[] point = seedPoints.get(idx);

        // 초록
        map[point[0]][point[1]] = 3;
        seed(idx + 1, Gcnt + 1, Rcnt);

        // 빨강
        map[point[0]][point[1]] = 4;
        seed(idx + 1, Gcnt, Rcnt + 1);

        // 아무것도 안심기
        map[point[0]][point[1]] = 2;
        seed(idx + 1, Gcnt, Rcnt);
    }

    static void bfs() {
        Plant[][] plants = new Plant[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;

        // 초기 배양액 위치 큐에 삽입
        for (int[] point : seedPoints) {
            int r = point[0];
            int c = point[1];
            if (map[r][c] == 3 || map[r][c] == 4) {
                plants[r][c] = new Plant(0, map[r][c]);
                // 0초에 r,c에 해당 색상 존재
                queue.offer(new int[]{r, c});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            // 꽃이 피면 전파 중단
            if (plants[r][c].color == 5) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && (map[nr][nc] == 1 || map[nr][nc] == 2)) {
                    if (plants[nr][nc] == null) {
                        // 아무것도 없는 경우 전파
                        plants[nr][nc] = new Plant(plants[r][c].time + 1, plants[r][c].color);
                        queue.offer(new int[]{nr, nc});
                    } else {
                        if ((plants[nr][nc].time == plants[r][c].time + 1
                                && plants[nr][nc].color != plants[r][c].color && plants[nr][nc].color != 5)) {
                            // 동시에 도착했고 색상이 다르면서 아직 꽃이 안 핀 경우
                            plants[nr][nc].color = 5;
                            cnt++;
                        }
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }
    }
}
