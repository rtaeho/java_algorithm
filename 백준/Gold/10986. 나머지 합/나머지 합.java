/*
문제
수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

입력
첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

출력
첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.

예제 입력 1
5 3
1 2 3 1 2
예제 출력 1
7
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] prefixSum = new long[N + 1];
        long[] modCount = new long[M]; // 나머지가 같은 경우를 카운트
        long result = 0;

        for (int i = 1; i <= N; i++) {
            prefixSum[i] = (prefixSum[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (prefixSum[i] == 0) {
                result++; // 누적합 자체가 M으로 나누어 떨어지는 경우
            }
            modCount[(int) prefixSum[i]]++;
        }

        // 나머지가 같은 경우의 수 계산
        for (int i = 0; i < M; i++) {
            if (modCount[i] > 1) {
                result += (modCount[i] * (modCount[i] - 1)) / 2; // 조합 공식
            }
        }

        System.out.println(result);
    }
}