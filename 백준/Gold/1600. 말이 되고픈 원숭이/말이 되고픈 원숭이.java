import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int k, w, h;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dhx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dhy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k + 1];
        for (int y = 0; y < h; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < w; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];
                int nk = cur[2];

                if (y == h - 1 && x == w - 1) {
                    return cnt;
                }
                // 기본
                for (int dir = 0; dir < 4; dir++) {
                    int ty = y + dy[dir];
                    int tx = x + dx[dir];

                    if (ty >= 0 && ty < h && tx >= 0 && tx < w) {
                        if (map[ty][tx] == 0 && !visited[ty][tx][nk]) {
                            queue.offer(new int[]{ty, tx, nk});
                            visited[ty][tx][nk] = true;
                        }
                    }
                }
                if (nk < k) {
                    for (int j = 0; j < 8; j++) {
                        int thy = y + dhy[j];
                        int thx = x + dhx[j];

                        if (thy >= 0 && thy < h && thx >= 0 && thx < w) {
                            if (map[thy][thx] == 0 && !visited[thy][thx][nk + 1]) {
                                queue.offer(new int[]{thy, thx, nk + 1});
                                visited[thy][thx][nk + 1] = true;
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
