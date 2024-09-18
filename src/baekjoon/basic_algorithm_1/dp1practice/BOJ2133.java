/*
문제
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

입력
첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

출력
첫째 줄에 경우의 수를 출력한다.

예제 입력 1
2
예제 출력 1
3
힌트
아래 그림은 3×12 벽을 타일로 채운 예시이다.


 */
package baekjoon.basic_algorithm_1.dp1practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }
        System.out.println(dp[N]);
    }
}
