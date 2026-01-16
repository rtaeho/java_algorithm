package baekjoon.year2026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int r, c;
    static char[][] map;
    static int[][] fireTime;
    static int[][] jihoonTime;
    static Queue<int[]> fireQ = new LinkedList<>();
    static Queue<int[]> jihoonQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        fireTime = new int[r][c];
        jihoonTime = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                char tmp = str.charAt(j);
                map[i][j] = tmp;
                fireTime[i][j] = -1;
                jihoonTime[i][j] = -1;
                // -1은 도달하지 않음
                if(tmp == 'F') {
                    fireTime[i][j] = 0;
                    // 0초에 도달(시작점)
                    fireQ.add(new int[]{i, j});
                } else if(tmp == 'J') {
                    jihoonTime[i][j] = 0;
                    jihoonQ.add(new int[]{i, j});
                }
            }
        }

        bfsFire();
        bfsJihoon();
    }
    private static void bfsFire() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[1];
            int y = cur[0];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                    if (fireTime[ny][nx] == -1 && map[ny][nx] != '#') {
                        fireTime[ny][nx] = fireTime[y][x] + 1;
                        fireQ.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private static void bfsJihoon(){
        while(!jihoonQ.isEmpty()){
            int cur[] = jihoonQ.poll();
            int x = cur[1];
            int y = cur[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 탈출
                if (ny < 0 || ny >= c || nx < 0 || nx >= r) {
                    System.out.println(jihoonTime[y][x] + 1);
                    return;
                }
                if (map[ny][nx] == '.' && jihoonTime[ny][nx] == -1) {
                    if(fireTime[ny][nx] > jihoonTime[y][x] + 1 || fireTime[ny][nx] == -1) {
                        jihoonTime[ny][nx] = jihoonTime[y][x] + 1;
                        jihoonQ.add(new int[]{ny, nx} );
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
