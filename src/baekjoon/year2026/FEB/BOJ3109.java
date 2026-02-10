package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {
    static char[][] map;
    static int[] dr = {-1, 0, 1};
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        int answer = 0;

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean dfs(int r, int c) {
        map[r][c] = 'x';

        if (c == C - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];
            int nc = c + 1;

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }
}
