package baekjoon.year2026.JAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int n, m;
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }

    static int bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 1;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = tmp[1] + dx[k];
                int y = tmp[0] + dy[k];
                if(x >= 0 && y >= 0 && x < m && y < n){
                    if(arr[y][x] == 1 && !visited[y][x]){
                        visited[y][x] = true;
                        area++;
                        queue.add(new int[]{y, x});
                    }
                }
            }
        }
        return area;
    }
}
