/*
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

N개의 자연수 중에서 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1
3 1
4 5 2
예제 출력 1
2
4
5
예제 입력 2
4 2
9 8 7 1
예제 출력 2
1 7
1 8
1 9
7 8
7 9
8 9
예제 입력 3
4 4
1231 1232 1233 1234
예제 출력 3
1231 1232 1233 1234
 */
package baekjoon.basicalgorithm2.bruteforceNM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
    public static int N, M;
    public static int[] arr;
    public static int[] input;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        visit = new boolean[N];
        arr = new int[M];
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int at) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = input[i];
                dfs(depth + 1, i);
                visit[i] = false;
            }
        }

    }
}
