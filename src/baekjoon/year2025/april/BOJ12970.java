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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int aCount = 0; aCount <= N; aCount++) {
            int bCount = N - aCount;
            int maxPair = aCount * bCount;

            if (maxPair >= K) {
                // A가 앞쪽에 있어야 (A, B) 쌍이 생김
                StringBuilder sb = new StringBuilder();
                int[] result = new int[N];

                // 일단 모두 B로 초기화
                for (int i = 0; i < N; i++) {
                    result[i] = 'B';
                }

                // A를 왼쪽부터 하나씩 배치하며 쌍의 개수를 맞춤
                for (int i = 0; i < aCount; i++) {
                    int pos = Math.min(K, bCount); // A가 만들 수 있는 최대 쌍 수
                    result[i] = 'A';
                    K -= pos;
                }

                // 결과 출력
                for (int i = 0; i < N; i++) {
                    sb.append((char) result[i]);
                }
                System.out.println(sb.toString());
                return;
            }
        }

        // 조건을 만족하는 문자열이 없으면
        System.out.println("-1");
    }
}
