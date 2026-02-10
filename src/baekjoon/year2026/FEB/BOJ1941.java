package baekjoon.year2026.FEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941 {
    static char[][] map = new char[5][5];
    static int answer = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static LinkedList<int[]> selected = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        combination(0, 0, 0);

        System.out.println(answer);

    }

    static void combination(int idx, int cnt, int sCnt) {
        if (cnt - sCnt > 3) {
            return;
        }
        // 조합의 특성을 반영하여 idx부터 시작하고 뽑은 개수를 cnt로 전달
        // S의 개수 추적
        if (cnt == 7) {
            if (sCnt >= 4) {
                if (isConnected()) {
                    answer++;
                }
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            selected.add(new int[]{i / 5, i % 5});
            int ds = map[i / 5][i % 5] == 'S' ? 1 : 0;
            combination(i + 1, cnt + 1, sCnt + ds);
            selected.removeLast();
        }
    }

    static boolean isConnected() {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];
        queue.offer(selected.getFirst());
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 상하좌우에 연결되어있나 -> 인접
                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                    for (int j = 0; j < 7; j++) {
                        // 7개에 대해서 탐색
                        if (!visited[j]) {
                            int[] cell = selected.get(j);
                            if (cell[0] == ny && cell[1] == nx) {
                                visited[j] = true;
                                queue.offer(cell);
                                cnt++;
                            }
                        }
                    }
                }

            }
        }
        return cnt == 7;
    }
}
