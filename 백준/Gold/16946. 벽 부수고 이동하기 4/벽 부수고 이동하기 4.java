/*
문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 한 칸에서 다른 칸으로 이동하려면, 두 칸이 인접해야 한다. 두 칸이 변을 공유할 때, 인접하다고 한다.

각각의 벽에 대해서 다음을 구해보려고 한다.

벽을 부수고 이동할 수 있는 곳으로 변경한다.
그 위치에서 이동할 수 있는 칸의 개수를 세어본다.
한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다.

출력
맵의 형태로 정답을 출력한다. 원래 빈 칸인 곳은 0을 출력하고, 벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.

예제 입력 1
3 3
101
010
101
예제 출력 1
303
050
303
예제 입력 2
4 5
11001
00111
01010
10101
예제 출력 2
46003
00732
06040
50403
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, group;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Integer, Integer> areaSize = new HashMap<>();
    static int groupId = 2; // 0,1은 이미 사용된 값이므로 2부터 시작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 1️⃣ 각 영역을 탐색하여 그룹화 & 크기 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j, groupId++);
                }
            }
        }

        // 2️⃣ 벽을 부쉈을 때 이동할 수 있는 칸 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    sb.append(getNewAreaSize(i, j) % 10);
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // BFS를 사용하여 하나의 영역을 탐색하고 크기 저장
    static void bfs(int x, int y, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        group[x][y] = id;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d], ny = cy + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        group[nx][ny] = id;
                        count++;
                    }
                }
            }
        }
        // 영역 ID별 크기 저장
        areaSize.put(id, count);
    }

    // 벽을 부쉈을 때 이동 가능한 칸 계산
    static int getNewAreaSize(int x, int y) {
        Set<Integer> uniqueGroups = new HashSet<>();
        int newSize = 1; // 현재 벽을 포함한 크기

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                int gId = group[nx][ny];
                if (gId > 1 && uniqueGroups.add(gId)) { // 중복 방지
                    newSize += areaSize.get(gId);
                }
            }
        }
        return newSize;
    }
}
