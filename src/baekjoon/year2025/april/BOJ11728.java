/*
문제
정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)

둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 109보다 작거나 같은 정수이다.

출력
첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.

예제 입력 1
2 2
3 5
2 9
예제 출력 1
2 3 5 9
예제 입력 2
2 1
4 7
1
예제 출력 2
1 4 7
예제 입력 3
4 3
2 3 5 9
1 4 7
예제 출력 3
1 2 3 4 5 7 9
 */
package baekjoon.year2025.april;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 배열 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 A 입력
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터로 병합
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (A[i] <= B[j]) {
                sb.append(A[i++]).append(' ');
            } else {
                sb.append(B[j++]).append(' ');
            }
        }

        // 남은 원소 처리
        while (i < N) {
            sb.append(A[i++]).append(' ');
        }
        while (j < M) {
            sb.append(B[j++]).append(' ');
        }

        // 출력
        System.out.println(sb);
    }
}