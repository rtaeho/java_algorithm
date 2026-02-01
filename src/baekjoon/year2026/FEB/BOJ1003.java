package baekjoon.year2026.FEB;

import java.io.*;

public class BOJ1003 {
    // N의 범위가 40까지이므로 크기를 41로 설정
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // DP 테이블 초기화
        dp[0][0] = 1; dp[0][1] = 0; // N이 0일 때: 0은 1번, 1은 0번
        dp[1][0] = 0; dp[1][1] = 1; // N이 1일 때: 0은 0번, 1은 1번

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.print(sb);
    }
}