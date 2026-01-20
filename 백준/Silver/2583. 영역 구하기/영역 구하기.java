import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int m, n, k;
    // 동서남북
    static int[] dx = {1, -1, 0, 0,};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[y][x] = 1;
                }
            }
        }

        // 오름차순 정렬 위해 stringBuilder 대신 list 사용
        ArrayList<Integer> areaSizes = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    areaSizes.add(bfs(i, j));
                }
            }
        }
        Collections.sort(areaSizes);

        System.out.println(areaSizes.size());
        for (Integer i : areaSizes) {
            System.out.print(i + " ");
        }
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int tx = cur[0] + dx[dir];
                int ty = cur[1] + dy[dir];

                if (tx >= 0 && tx < m && ty >= 0 && ty < n) {
                    if (!visited[tx][ty] && map[tx][ty] == 0) {
                        visited[tx][ty] = true;
                        queue.offer(new int[]{tx, ty});
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
