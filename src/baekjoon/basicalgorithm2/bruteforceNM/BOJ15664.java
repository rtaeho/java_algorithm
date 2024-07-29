/*
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
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
7 9
9 9
예제 입력 3
4 4
1 1 2 2
예제 출력 3
1 1 2 2
 */
package baekjoon.basicalgorithm2.bruteforceNM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15664 {
    static int N, M;
    static int arr[], result[];
    static StringBuilder sb = new StringBuilder();
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        result = new int[M];
        isVisited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        DFS(1, 0);
        System.out.println(sb);
    }

    public static void DFS(int start, int depth) {
        int num = 0;

        if (depth == M) {
            for (int k : result)
                sb.append(k).append(' ');

            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!isVisited[i]) {
                if (num == arr[i])
                    continue;
            }

            isVisited[i] = true;
            result[depth] = arr[i];
            DFS(i + 1, depth + 1);
            isVisited[i] = false;
            num = arr[i];
        }
    }
}
