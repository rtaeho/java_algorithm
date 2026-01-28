import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    // 각 방에 있는 스위치 정보 (ArrayList의 2차원 리스트 구조)
    static List<int[][]> switches; // 혹은 아래처럼 2차원 배열 형태의 List 활용
    static List<int[]>[][] adj;
    static boolean[][] isLightOn;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 로우 타입 경고를 피하기 위해 List로 초기화
        adj = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[x][y].add(new int[]{a, b});
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});

        isLightOn = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        isLightOn[1][1] = true;
        visited[1][1] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 1. 현재 방에서 켤 수 있는 모든 불을 켠다.
            for (int[] next : adj[x][y]) {
                int nx = next[0];
                int ny = next[1];

                if (!isLightOn[nx][ny]) {
                    isLightOn[nx][ny] = true;
                    count++;

                    // 핵심: 불을 켰는데, 그 방이 이미 주변 방문 기록 덕분에 '갈 수 있는' 상태라면?
                    // 즉시 큐에 넣어서 탐색을 이어간다.
                    if (canMove(nx, ny)) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

            // 2. 현재 방에서 상하좌우로 이동한다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                // 불이 켜져 있고, 아직 방문하지 않은 곳이라면 이동
                if (isLightOn[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return count;
    }

    // 해당 방의 주변(상하좌우) 중에 이미 방문한 곳이 있는지 체크하는 함수
    private static boolean canMove(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;
            if (visited[nx][ny]) return true;
        }
        return false;
    }
}