import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, P;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]>[] playerQueues;
    static int[] S;
    static int[] castleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        S = new int[P + 1];
        playerQueues = new LinkedList[P + 1];
        castleCount = new int[P + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            playerQueues[i] = new LinkedList<>();
        }

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] >= '1' && map[i][j] <= '9') {
                    playerQueues[map[i][j] - '0'].offer(new int[]{i, j});
                    castleCount[map[i][j] - '0']++;
                }
            }
        }

        while(true){
            boolean anyMoved = false;
            for (int player = 1; player <= P; player++) {
                boolean moved = bfs(player);
                if (moved) {
                    anyMoved = true;
                }
            }
            if (!anyMoved) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            sb.append(castleCount[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static boolean bfs(int player) {
        Queue<int[]> queue = playerQueues[player];
        int moveCount = S[player];
        boolean moved = false;

        for (int i = 0; i < moveCount; i++) {
            int size = queue.size();
            if (size == 0) {
                break;
            }

            while (size-- > 0) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];

                for (int dir = 0; dir < 4; dir++) {
                    int ty = y + dy[dir];
                    int tx = x + dx[dir];
                    if (ty >= 0 && ty < N && tx >= 0 && tx < M) {
                        if (map[ty][tx] == '.') {
                            map[ty][tx] = (char) (player + '0');
                            castleCount[player]++;
                            queue.offer(new int[]{ty, tx});
                            moved = true;
                        }
                    }
                }
            }
        }
        return moved;
    }
}
