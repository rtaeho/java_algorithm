/*
문제
1부터 N까지의 수를 한 번씩 이용해서 가장 긴 증가하는 부분 수열의 길이가 M이고, 가장 긴 감소하는 부분 수열의 길이가 K인 수열을 출력한다.

입력
첫째 줄에 세 정수 N, M, K가 주어진다.

출력
첫째 줄에 문제의 조건을 만족하는 수열을 출력한다. 만약, 조건을 만족하는 수열이 없다면 -1을 출력한다.

제한
1 ≤ N ≤ 500
1 ≤ M, K ≤ N
예제 입력 1
4 2 2
예제 출력 1
2 1 4 3
예제 입력 2
4 4 1
예제 출력 2
1 2 3 4
예제 입력 3
4 3 2
예제 출력 3
1 4 2 3
예제 입력 4
4 4 2
예제 출력 4
-1
예제 입력 5
13 5 4
예제 출력 5
1 3 2 13 10 11 12 6 8 9 4 5 7
 */
package baekjoon.year2025.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
        실패 조건 1: M + K - 1 > N
        M개의 블록과 K개의 감소 길이를 연결할 때,
        겹치는 한 칸을 제외한 최소 수열 길이는 (M + K - 1)
        이보다 N이 작다면 수열을 만들 수 없음

        실패 조건 2: M * K < N
        각 증가 구간은 K 이하로 구성해야 하므로,
        각 블록에 최대 K개의 숫자만 넣을 수 있다.
        M개의 블록에 K개씩 넣어도 수열을 커버하지 못하면 불가능
        */
        if (M + K - 1 > N || M * K < N) {
            System.out.println(-1);
            return;
        }

        int[] blockLens = new int[M];
        for (int i = 0; i < M; i++) {
            blockLens[i] = 1;
        }

        int remain = N - M;
        int idx = 0;
        // 각 증가 블록에 최대 K까지 채우면서 분배
        while (remain > 0) {
            if (blockLens[idx] < K) {
                blockLens[idx]++;
                remain--;
            } else {
                idx++;
            }
        }

        // 각 블록을 뒤집어서 내림차순으로 출력 → 블록 자체는 감소, 선두 숫자는 증가 순으로 배치됨
        int curr = 1;
        StringBuilder sb = new StringBuilder();
        for (int len : blockLens) {
            for (int i = curr + len - 1; i >= curr; i--) {
                sb.append(i).append(" ");
            }
            curr += len;
        }
        System.out.println(sb.toString().trim());
    }
}
