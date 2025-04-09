/*
문제
정수 N과 K가 주어졌을 때, 다음 두 조건을 만족하는 문자열 S를 찾는 프로그램을 작성하시오.

문자열 S의 길이는 N이고, 'A', 'B'로 이루어져 있다.
문자열 S에는 0 ≤ i < j < N 이면서 s[i] == 'A' && s[j] == 'B'를 만족하는 (i, j) 쌍이 K개가 있다.
입력
첫째 줄에 N과 K가 주어진다. (2 ≤ N ≤ 50, 0 ≤ K ≤ N(N-1)/2)

출력
첫째 줄에 문제의 조건을 만족하는 문자열 S를 출력한다. 가능한 S가 여러 가지라면, 아무거나 출력한다. 만약, 그러한 S가 존재하지 않는 경우에는 -1을 출력한다.

예제 입력 1
3 2
예제 출력 1
ABB
예제 입력 2
2 0
예제 출력 2
BA
예제 입력 3
5 8
예제 출력 3
-1
예제 입력 4
10 12
예제 출력 4
BAABBABAAB
 */
package baekjoon.year2025.april;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ12970 {
    public static class Main {
        static int N, K;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // A 개수 a를 0부터 N까지 시도
            for (int a = 0; a <= N; a++) {
                int b = N - a;

                // A와 B로 만들 수 있는 최대 쌍 수는 a * b
                if (a * b < K) {
                    continue;
                }

                // B를 먼저 배치하고, A를 어디에 넣을지 정한다
                int[] A = new int[b + 1];  // A[i]: i번째 B 뒤에 놓을 A의 수

                for (int i = 0; i < a; i++) {
                    // 오른쪽부터 최대한 B 뒤에 넣기
                    int idx = Math.min(K, b);
                    A[idx]++;
                    K -= idx;
                }

                // 출력 (B를 기준으로 A를 왼쪽에 붙이는 방식)
                StringBuilder sb = new StringBuilder();
                for (int i = b; i >= 0; i--) {
                    for (int j = 0; j < A[i]; j++) {
                        sb.append("A");
                    }
                    if (i > 0) {
                        sb.append("B");
                    }
                }

                System.out.println(sb);
                return;
            }

            // 만들 수 없는 경우
            System.out.println("-1");
        }
    }
}