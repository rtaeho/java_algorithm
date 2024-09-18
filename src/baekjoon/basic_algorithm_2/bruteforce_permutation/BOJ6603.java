package baekjoon.basic_algorithm_2.bruteforce_permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int k;
    static int[] S;
    static int[] combination;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;  // 0이 입력되면 종료
            S = new int[k];
            combination = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);  // 깊이 우선 탐색으로 조합 찾기
            sb.append("\n");  // 각 테스트 케이스 사이에 빈 줄 추가
        }

        System.out.print(sb.toString());
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {  // 6개의 숫자를 선택했을 때
            for (int i = 0; i < 6; i++) {
                sb.append(combination[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            combination[depth] = S[i];
            dfs(i + 1, depth + 1);
        }
    }
}
