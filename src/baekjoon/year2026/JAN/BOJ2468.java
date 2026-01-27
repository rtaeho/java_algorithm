package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        int maxHeight = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[n][n];
            int curArea = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] > h && !visited[i][j]){
                        bfs(i, j, h);
                        curArea++;
                    }
                }
            }
            maxArea = Math.max(maxArea, curArea);
        }

        System.out.println(maxArea);
    }

    static void bfs(int i, int j, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int areaCount = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            for (int dir = 0; dir < 4; dir++) {
                int ty = y + dy[dir];
                int tx = x + dx[dir];

                if(ty >= 0 && ty < n && tx >= 0 && tx < n){
                    if(!visited[ty][tx] && map[ty][tx] > h){
                        visited[ty][tx] = true;
                        queue.offer(new int[]{ty, tx});
                    }
                }
            }
        }
    }
}