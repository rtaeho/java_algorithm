/*
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1
3 1
4 4 2
예제 출력 1
2
4
예제 입력 2
4 2
9 7 9 1
예제 출력 2
1 7
1 9
7 1
7 9
9 1
9 7
9 9
예제 입력 3
4 4
1 1 1 1
예제 출력 3
1 1 1 1
 */
package baekjoon.basic_algorithm_2.bruteforce_NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
    static int[] numArr;
    static int[] out;
    static boolean[] visited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numArr = new int[N];
        visited = new boolean[N];
        out = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numArr);

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                System.out.print(out[i] + " ");
            System.out.println();
        } else {
            int before = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;

                if (before != numArr[i]) {
                    visited[i] = true;
                    out[cnt] = numArr[i];
                    before = numArr[i];
                    dfs(cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
