/*
문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.

예제 입력 1
6
20 1 15 8 4 10
예제 출력 1
62
 */
package baekjoon.basicalgorithm2.brutefocepermutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ10819 {
    static int N;
    static int[] A;
    static boolean[] visited;
    static ArrayList<Integer> perm;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];
        perm = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(maxValue);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            calculate();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(A[i]);
                dfs(depth + 1);
                perm.remove(perm.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(perm.get(i) - perm.get(i + 1));
        }
        maxValue = Math.max(maxValue, sum);
    }
}

