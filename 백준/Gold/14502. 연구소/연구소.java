import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static int maxSafeArea = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new int[N][M];

        List<int[]> emptySpaces = new ArrayList<>();
        List<int[]> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
                if (lab[i][j] == 0) emptySpaces.add(new int[]{i, j});
                if (lab[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }

        dfs(emptySpaces, viruses, 0, 0);
        System.out.println(maxSafeArea);
    }

    static void dfs(List<int[]> emptySpaces, List<int[]> viruses, int start, int depth) {
        if (depth == 3) {
            maxSafeArea = Math.max(maxSafeArea, calculateSafeArea(viruses));
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            int[] space = emptySpaces.get(i);
            lab[space[0]][space[1]] = 1; // 벽 세우기
            dfs(emptySpaces, viruses, i + 1, depth + 1);
            lab[space[0]][space[1]] = 0; // 벽 제거
        }
    }

    static int calculateSafeArea(List<int[]> viruses) {
        boolean[][] visited = new boolean[N][M];
        int[][] tempLab = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(lab[i], 0, tempLab[i], 0, M);
        }

        Queue<int[]> queue = new LinkedList<>(viruses);
        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = virus[0] + dx[d];
                int ny = virus[1] + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2; // 바이러스 확산
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) safeArea++;
            }
        }
        return safeArea;
    }
}