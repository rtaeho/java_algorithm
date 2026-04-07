import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int N, M;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int TEST_CASE = 0; TEST_CASE < T; TEST_CASE++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= N + 1; k++) {
                        int cost = getCost(k);
                        int houseCnt = getHouseCount(i, j, k);
                        if (houseCnt * M >= cost) {
                            max = Math.max(max, houseCnt);
                        }
                    }
                }
            }

            sb.append("#").append(TEST_CASE + 1).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    static int getCost(int k) {
        return k * k + (k - 1) * (k - 1);
    }

    static int getHouseCount(int x, int y, int k) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && (Math.abs(x - i) + Math.abs(y - j)) < k) {
                    count++;
                }
            }
        }
        return count;
    }
}