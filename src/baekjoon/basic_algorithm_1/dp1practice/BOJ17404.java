/*
문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

예제 입력 1
3
26 40 83
49 60 57
13 89 99
예제 출력 1
110
예제 입력 2
3
1 100 100
100 1 100
100 100 1
예제 출력 2
3
예제 입력 3
3
1 100 100
100 100 100
1 100 100
예제 출력 3
201
예제 입력 4
6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91
예제 출력 4
208
예제 입력 5
8
71 39 44
32 83 55
51 37 63
89 29 100
83 58 11
65 13 15
47 25 29
60 66 19
예제 출력 5
253
 */
package baekjoon.basic_algorithm_1.dp1practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][3];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1001;

        //1번 집이 R
        dp = new int[N + 1][3];
        dp[1][0] = arr[1][0];
        dp[1][1] = dp[1][2] = 1001;
        answer = Math.min(recur(N, 1), recur(N, 2));

        //1번 집이 G
        dp = new int[N + 1][3];
        dp[1][1] = arr[1][1];
        dp[1][2] = dp[1][0] = 1001;
        answer = Math.min(answer, Math.min(recur(N, 0), recur(N, 2)));

        //1번 집이 B
        dp = new int[N + 1][3];
        dp[1][2] = arr[1][2];
        dp[1][0] = dp[1][1] = 1001;
        answer = Math.min(answer, Math.min(recur(N, 0), recur(N, 1)));


        System.out.print(answer);
    }

    public static int recur(int N, int color) {
        if (dp[N][color] == 0) {
            dp[N][color] = Math.min(recur(N - 1, (color + 1) % 3), recur(N - 1, (color + 2) % 3)) + arr[N][color];
        }
        return dp[N][color];
    }

}
