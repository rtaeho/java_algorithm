/*
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

1+2+1
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

예제 입력 1
3
4
7
10
예제 출력 1
3
9
27
 */
package baekjoon.basic_algorithm_1.dynamicprogramming1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long dp[][] = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 4; j <= arr[i]; j++) {
                dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % 1000000009;
                dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % 1000000009;
                dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % 1000000009;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % 1000000009);
        }
        br.close();
    }
}
