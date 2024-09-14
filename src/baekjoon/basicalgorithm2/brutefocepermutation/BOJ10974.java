/*
문제
N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

출력
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

예제 입력 1
3
예제 출력 1
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1
 */
package baekjoon.basicalgorithm2.brutefocepermutation;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ10974 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        output = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permute(0);
        System.out.println(sb.toString());
    }

    static void permute(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }
}
